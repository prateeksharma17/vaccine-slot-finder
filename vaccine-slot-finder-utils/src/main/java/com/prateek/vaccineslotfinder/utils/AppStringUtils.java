package com.prateek.vaccineslotfinder.utils;

public enum AppStringUtils {
	
	FIND_BY_PINCODE_LINK("https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin?pincode=$PIN$&date=$DATE$"),
	PINCODE("PINCODE"),
	DATE("DATE"),
	SEARCH("FIND SLOTS"),
	PINCODE_API_LINK("https://api.postalpincode.in/pincode/$PIN$"),
	ERROR("Error"),
	SUCCESS("Success"),	
	INVALID_PINCODE_FORMAT("Length of PINCODE should be 6 and should contain only digits!"),
	PINCODE_NOT_FOUND("PINCODE not found!"),
	SELECT_DAY("Select Day"),
	SELECT_MONTH("Select Month"),
	YEAR("Year"),
	YEAR_2021("2021"),
	USER_AGENT("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36"),
	NAME("Name"),
	ADDRESS("Address"),
	STATE_NAME("State Name"),
	DISTRICT_NAME("District Name"),
	FEE_TYPE("Fee Type"),
	DOSE1("Available Capacity Dose 1"),
	DOSE2("Available Capacity Dose 2"),
	CAPACITY("Available Capacity"),
	FEE("Fee"),
	MIN_AGE_LIMIT("Min Age Limit"),
	VACCINE("Vaccine"),
	SLOTS("Slots"),
	NO_SLOTS_AVAILABLE("No slots available! Please try with a different date.");
		
	private final String string;
	
	private AppStringUtils(String string) {
		this.string = string;
	}
	
	public String getString() {
		return this.string;
	}

}
