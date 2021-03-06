package com.prateek.vaccineslotfinder.ui;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class LogoLayoutFactory implements UIComponentBuilder {
	
	private class LogoLayout extends VerticalLayout{		
		
		private static final long serialVersionUID = -944686544435629179L;
		
		private Embedded logo;
		
		public LogoLayout init() {
			logo = new Embedded();
			logo.setSource(new ThemeResource("../../images/banner.gif"));
			logo.setWidth("954px");
			logo.setHeight("300px");
			
			return this;		
		}
		
		public LogoLayout layout() {
			addComponent(logo);
			setComponentAlignment(logo, Alignment.MIDDLE_CENTER);
			
			return this;
		}		
	}	

	public Component createComponent() {
		return new LogoLayout().init().layout();
	}

}
