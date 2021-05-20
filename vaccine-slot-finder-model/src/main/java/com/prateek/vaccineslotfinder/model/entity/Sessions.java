package com.prateek.vaccineslotfinder.model.entity;

import java.util.List;

public class Sessions {
	
	private List<CenterInfo> sessions;
	
	public Sessions() {
		// Default Constructor
	}

	public List<CenterInfo> getSessions() {
		return sessions;
	}

	public void setSessions(List<CenterInfo> sessions) {
		this.sessions = sessions;
	}

	@Override
	public String toString() {
		return "Sessions [sessions=" + sessions + "]";
	}	

}
