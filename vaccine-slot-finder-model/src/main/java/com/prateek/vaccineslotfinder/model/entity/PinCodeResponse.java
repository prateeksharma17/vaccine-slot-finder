package com.prateek.vaccineslotfinder.model.entity;

import java.util.List;

public class PinCodeResponse {
	
	private String Message;
	private String Status;
	private List<PostOffice> PostOffice;
	
	public PinCodeResponse() {
		// Default Constructor
	}

	public PinCodeResponse(String message, String status,
			List<PostOffice> postOffice) {		
		Message = message;
		Status = status;
		PostOffice = postOffice;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public List<PostOffice> getPostOffice() {
		return PostOffice;
	}

	public void setPostOffice(List<PostOffice> postOffice) {
		PostOffice = postOffice;
	}

	@Override
	public String toString() {
		return "PinCodeResponse [Message=" + Message + ", Status=" + Status + ", PostOffice=" + PostOffice + "]";
	}	

}
