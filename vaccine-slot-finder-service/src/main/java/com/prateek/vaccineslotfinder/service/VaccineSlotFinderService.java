package com.prateek.vaccineslotfinder.service;

import java.util.List;

import com.prateek.vaccineslotfinder.model.entity.PinCodeResponse;
import com.prateek.vaccineslotfinder.model.entity.PostOffice;
import com.prateek.vaccineslotfinder.model.entity.Sessions;

public interface VaccineSlotFinderService {

	Sessions findByPincode(String pincode, String date);
	
	List<String> getListOfMonths();
	
	List<String> getListOfDates();
	
	PinCodeResponse getListOfPOFromPinCode(String pincode);
	
	List<String> getListOfPONames(List<PostOffice> postOfficeList);	
	
	String getDateString(String day, String month, String year);
	
}
