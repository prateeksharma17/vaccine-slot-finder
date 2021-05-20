package com.prateek.vaccineslotfinder.ui;

import com.vaadin.server.FontAwesome;
import com.vaadin.shared.Position;
import com.vaadin.ui.Notification;
import com.vaadin.ui.themes.ValoTheme;

@org.springframework.stereotype.Component
public class NotificationUtils {
	
	public static Notification getErrorNotification(String message) {
		final int delay = 5000;
		final Notification notification = new Notification("<b>"+message+"</b>",
				Notification.Type.ERROR_MESSAGE);
		notification.setHtmlContentAllowed(true);
	    notification.setStyleName(ValoTheme.NOTIFICATION_CLOSABLE);
	    notification.setPosition(Position.MIDDLE_CENTER);
	    notification.setIcon(FontAwesome.BELL);
	    notification.setDelayMsec(delay);
	    
	    return notification;
	}

}
