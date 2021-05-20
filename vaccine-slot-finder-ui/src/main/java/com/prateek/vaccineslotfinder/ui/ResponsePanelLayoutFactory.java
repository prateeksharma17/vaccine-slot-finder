package com.prateek.vaccineslotfinder.ui;

import com.prateek.vaccineslotfinder.model.entity.CenterInfo;
import com.prateek.vaccineslotfinder.utils.AppStringUtils;
import com.prateek.vaccineslotfinder.utils.UtilityMethods;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class ResponsePanelLayoutFactory{
	
	private class ResponsePanelLayout extends VerticalLayout{		
		
		private static final long serialVersionUID = -2491711357130287818L;
		private CenterInfo centerInfo;
		private TextField name;
		private TextField address;
		private TextField stateName;
		private TextField districtName;
		private TextField feeType;
		private TextField date;
		private TextField availableCapacityDose1;
		private TextField availableCapacityDose2;
		private TextField availableCapacity;
		private TextField fee;
		private TextField minAgeLimit;
		private TextField vaccine;
		private TextArea slots;
		
		
		ResponsePanelLayout(CenterInfo centerInfo){
			this.centerInfo = centerInfo;
		}
		
		
		ResponsePanelLayout init() {
			name = new TextField(AppStringUtils.NAME.getString());
			address = new TextField(AppStringUtils.ADDRESS.getString());
			stateName = new TextField(AppStringUtils.STATE_NAME.getString());
			districtName = new TextField(AppStringUtils.DISTRICT_NAME.getString());
			feeType = new TextField(AppStringUtils.FEE_TYPE.getString());
			date = new TextField(AppStringUtils.DATE.getString());
			availableCapacityDose1 = new TextField(AppStringUtils.DOSE1.getString());
			availableCapacityDose2 = new TextField(AppStringUtils.DOSE2.getString());
			availableCapacity = new TextField(AppStringUtils.CAPACITY.getString());
			fee = new TextField(AppStringUtils.FEE.getString());
			minAgeLimit = new TextField(AppStringUtils.MIN_AGE_LIMIT.getString());
			vaccine = new TextField(AppStringUtils.VACCINE.getString());
			slots = new TextArea(AppStringUtils.SLOTS.getString());
			
			return this;
		}
		
		
		ResponsePanelLayout bind() {
			name.setValue(centerInfo.getName());
			address.setValue(centerInfo.getAddress());
			stateName.setValue(centerInfo.getState_name());
			districtName.setValue(centerInfo.getDistrict_name());
			feeType.setValue(centerInfo.getFee_type());
			date.setValue(centerInfo.getDate());
			availableCapacityDose1.setValue(centerInfo.getAvailable_capacity_dose1().toString());
			availableCapacityDose2.setValue(centerInfo.getAvailable_capacity_dose2().toString());
			availableCapacity.setValue(centerInfo.getAvailable_capacity().toString());
			fee.setValue(centerInfo.getFee());
			minAgeLimit.setValue(centerInfo.getMin_age_limit().toString());
			vaccine.setValue(centerInfo.getVaccine());
			slots.setValue(UtilityMethods.getSlotString(centerInfo.getSlots()));
			
			return this;
		}
		
		
		
		ResponsePanelLayout layout() {
			setMargin(true);
			setHeight("100%");
			setSpacing(true);
			
			name.setReadOnly(true);
			address.setReadOnly(true);
			stateName.setReadOnly(true);
			districtName.setReadOnly(true);
			feeType.setReadOnly(true);
			date.setReadOnly(true);
			availableCapacityDose1.setReadOnly(true);
			availableCapacityDose2.setReadOnly(true);
			availableCapacity.setReadOnly(true);
			fee.setReadOnly(true);
			minAgeLimit.setReadOnly(true);
			vaccine.setReadOnly(true);
			slots.setReadOnly(true);
			
			
			name.setIcon(FontAwesome.AMBULANCE);
			address.setIcon(FontAwesome.ROAD);
			stateName.setIcon(FontAwesome.BUILDING);
			districtName.setIcon(FontAwesome.TERMINAL);
			feeType.setIcon(FontAwesome.TINT);
			date.setIcon(FontAwesome.CALENDAR);
			availableCapacityDose1.setIcon(FontAwesome.GRADUATION_CAP);
			availableCapacityDose2.setIcon(FontAwesome.GRADUATION_CAP);
			availableCapacity.setIcon(FontAwesome.GRADUATION_CAP);
			fee.setIcon(FontAwesome.MONEY);
			minAgeLimit.setIcon(FontAwesome.IMAGE);
			vaccine.setIcon(FontAwesome.CUBE);
			slots.setIcon(FontAwesome.GEAR);
			
						
			GridLayout gridLayout = new GridLayout(3, 5);
			
			gridLayout.setSpacing(true);
			gridLayout.setSizeUndefined();
			
			gridLayout.addComponent(name, 0, 0);
			gridLayout.addComponent(address, 1, 0);
			gridLayout.addComponent(stateName, 2, 0);
			
			gridLayout.addComponent(districtName, 0, 1);
			gridLayout.addComponent(feeType, 1, 1);
			gridLayout.addComponent(date, 2, 1);
			
			gridLayout.addComponent(availableCapacityDose1, 0, 2);
			gridLayout.addComponent(availableCapacityDose2, 1, 2);
			gridLayout.addComponent(availableCapacity, 2, 2);
			
			gridLayout.addComponent(fee, 0, 3);
			gridLayout.addComponent(minAgeLimit, 1, 3);
			gridLayout.addComponent(vaccine, 2, 3);
			
			gridLayout.addComponent(slots, 0, 4);	
			
			addComponent(gridLayout);
			
			return this;
		}		
	}	
	
	public Component createComponent(CenterInfo centerInfo) {
		return new ResponsePanelLayout(centerInfo).init().bind().layout();
	}
}
