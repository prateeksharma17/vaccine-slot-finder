package com.prateek.vaccineslotfinder.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.prateek.vaccineslotfinder.model.entity.CenterInfo;
import com.prateek.vaccineslotfinder.model.entity.Sessions;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class ResponseUI {
	
	private class ResponseLayout extends VerticalLayout{
		
		private static final long serialVersionUID = 8191167153251779987L;
		
		private Sessions sessions;
		
		ResponseLayout(Sessions sessions){
			this.sessions = sessions;
		}
		
		
		ResponseLayout layout() {
			setMargin(true);
			setSpacing(true);
			
			setHeight("100%");
			
			List<CenterInfo> centerInfoList = sessions.getSessions();
			
			int counter = 1;
			
			for(CenterInfo centerInfo : centerInfoList) {	
				Panel panel = new Panel();
				Component component = responsePanelLayoutFactory.createComponent(centerInfo);				
				panel.setContent(component);
				panel.setSizeUndefined();
				panel.setCaptionAsHtml(true);
				panel.setCaption("<h3><center><b><u>Center - "+counter+"</u></b></center></h3>");
				addComponent(panel);
				
				counter++;
			}
			
			return this;
		}		
	}
	
	
	@Autowired
	private ResponsePanelLayoutFactory responsePanelLayoutFactory;
	
	public Component createComponent(Sessions sessions) {
		return new ResponseLayout(sessions).layout();
	}

}
