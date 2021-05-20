package com.prateek.vaccineslotfinder.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.prateek.vaccineslotfinder.service.VaccineSlotFinderService;
import com.prateek.vaccineslotfinder.utils.AppStringUtils;
import com.prateek.vaccineslotfinder.utils.UtilityMethods;
import com.vaadin.event.FieldEvents;
import com.vaadin.event.FieldEvents.BlurEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.prateek.vaccineslotfinder.model.entity.PinCodeResponse;
import com.prateek.vaccineslotfinder.model.entity.Sessions;


@org.springframework.stereotype.Component
public class ContentLayoutFactory implements UIComponentBuilder{
	
	private class ContentLayout extends VerticalLayout implements Button.ClickListener
	{		
		
		private static final long serialVersionUID = -7943724994080869206L;
		private TextField pinCode;		
		private ComboBox day;
		private ComboBox month;
		private TextField year;
		private Label poNames;
		private Button search;
		private GridLayout gridLayout;
		private Component resultsPanel;
		
		public ContentLayout init() {
			pinCode = new TextField(AppStringUtils.PINCODE.getString());
			
			pinCode.addBlurListener(new FieldEvents.BlurListener() {				
				private static final long serialVersionUID = -5378482199376416L;
				
				public void blur(BlurEvent event) {
					removeResults();
					poNames.setVisible(false);
					boolean isValidPincode = validatePinCode(pinCode.getValue());
					if(!isValidPincode) {
						Notification notification = NotificationUtils.getErrorNotification(AppStringUtils.INVALID_PINCODE_FORMAT.getString());					
					    notification.show(Page.getCurrent());						
					}
					else {						
						PinCodeResponse pinCodeResponse = vaccineSlotFinderService.getListOfPOFromPinCode(pinCode.getValue()); 
						if(pinCodeResponse==null) {
							Notification notification = NotificationUtils.getErrorNotification(AppStringUtils.PINCODE_NOT_FOUND.getString());					
						    notification.show(Page.getCurrent());								
						}
						else {
							List<String> poNamesList = vaccineSlotFinderService.getListOfPONames(pinCodeResponse.getPostOffice());
							poNames.setValue(UtilityMethods.getPONamesString(poNamesList, pinCode.getValue()));
							poNames.setStyleName(ValoTheme.LABEL_TINY);
							poNames.setVisible(true);
						}
					}					
				}
			});			
			
			day = new ComboBox(AppStringUtils.SELECT_DAY.getString());
			month = new ComboBox(AppStringUtils.SELECT_MONTH.getString());
			day.addItems(vaccineSlotFinderService.getListOfDates());
			month.addItems(vaccineSlotFinderService.getListOfMonths());
			day.setWidth("20%");
			
			year = new TextField(AppStringUtils.YEAR.getString());
			year.setValue(AppStringUtils.YEAR_2021.getString());
			year.setReadOnly(true);		
			
			poNames = new Label();
			poNames.setWidth("100%");
			
			search = new Button(AppStringUtils.SEARCH.getString());
			search.setStyleName(ValoTheme.BUTTON_FRIENDLY);
			search.setWidth("100%");
			search.addClickListener(this);
			
			gridLayout = new GridLayout(4,3);			
			
			return this;			
		}
		
		
		protected boolean validatePinCode(String pincode) {
			boolean isValidPinCode = true;
			if(!UtilityMethods.isNumber(pincode) || pincode.length()!=6)
				isValidPinCode = false;
			
			return isValidPinCode;			
		}


		public ContentLayout layout() {
			setMargin(true);
			
			pinCode.setIcon(FontAwesome.STAR);
			month.setIcon(FontAwesome.CALENDAR);
			day.setIcon(FontAwesome.BOOKMARK);
			year.setIcon(FontAwesome.TICKET);
			search.setIcon(FontAwesome.SEARCH);
			
			
			gridLayout.setSizeUndefined();
			gridLayout.setSpacing(true);
			gridLayout.addComponent(pinCode, 0, 0);			
			gridLayout.addComponent(month, 1, 0);
			gridLayout.addComponent(day, 2, 0);	
			gridLayout.addComponent(year, 3, 0);
			gridLayout.addComponent(poNames, 0, 1, 2, 1);
			gridLayout.addComponent(search, 0, 2);
			
			poNames.setVisible(false);
			
			addComponent(gridLayout);			
			
			return this;			
		}

		
		public void buttonClick(ClickEvent event) {
			removeResults();				
			
			boolean isValidPincode = validatePinCode(pinCode.getValue());
			if(!isValidPincode)
				Notification.show(AppStringUtils.INVALID_PINCODE_FORMAT.getString(), Type.ERROR_MESSAGE);
			else {
				String pincode = pinCode.getValue();
				
				String dayValue = (String) day.getValue();
				String monthValue = (String) month.getValue();
				String yearValue = year.getValue();
				
				String dateString = vaccineSlotFinderService.getDateString(dayValue, monthValue, yearValue);
				
				Sessions sessions = vaccineSlotFinderService.findByPincode(pincode, dateString);
				
				if(sessions==null || sessions.getSessions()==null || sessions.getSessions().isEmpty()) {					
					Notification notification = NotificationUtils.getErrorNotification(AppStringUtils.NO_SLOTS_AVAILABLE.getString());					
				    notification.show(Page.getCurrent());					
				}else {				
					resultsPanel = responseUI.createComponent(sessions);				
					addComponent(resultsPanel);
					resultsPanel.setVisible(true);					
				}
			}			
		}


		private void removeResults() {
			if(resultsPanel!=null) {
				resultsPanel.setVisible(false);
				removeComponent(resultsPanel);
			}			
		}
		
	}	
	
	
	@Autowired
	private VaccineSlotFinderService vaccineSlotFinderService;
	
	
	@Autowired
	private ResponseUI responseUI;

	
	public Component createComponent() {
		return new ContentLayout().init().layout();
	}

}
