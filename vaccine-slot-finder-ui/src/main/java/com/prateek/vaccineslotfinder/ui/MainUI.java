package com.prateek.vaccineslotfinder.ui;

import com.vaadin.spring.annotation.SpringUI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.prateek.vaccineslotfinder.service.VaccineSlotFinderServiceImpl;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path=MainUI.NAME)
@Title("COVID Vaccine Slot Finder")
@Theme("valo")
public class MainUI extends UI{	
	
	private static final long serialVersionUID = -5673229837674185507L;
	private static final Logger LOG = LoggerFactory.getLogger(MainUI.class);
	
	public static final String NAME = "/";
	
	@Autowired
	private LogoLayoutFactory logoLayoutFactory;
	
	@Autowired
	private ContentLayoutFactory contentLayoutFactory;

	@Override
	protected void init(VaadinRequest request) {
		
		LOG.info("Request received from IP : "+request.getRemoteHost());
		
		VerticalLayout rootLayout = new VerticalLayout();
		rootLayout.setSizeFull();
		rootLayout.setMargin(true);
		
		Panel logoPanel = new Panel();
		logoPanel.setWidth("85%");
		logoPanel.setHeightUndefined();
		
		Panel contentPanel = new Panel();
		contentPanel.setWidth("85%");
		contentPanel.setHeight("100%");
		
		Component logo = logoLayoutFactory.createComponent();
		Component content = contentLayoutFactory.createComponent();
		
		logoPanel.setContent(logo);
		contentPanel.setContent(content);
		
		rootLayout.addComponent(logoPanel);
		rootLayout.addComponent(contentPanel);		
		rootLayout.setComponentAlignment(contentPanel, Alignment.MIDDLE_CENTER);
		rootLayout.setComponentAlignment(logoPanel, Alignment.TOP_CENTER);
		rootLayout.setExpandRatio(contentPanel, 1);
		rootLayout.setSpacing(true);
		
		setContent(rootLayout);		
	}
}
