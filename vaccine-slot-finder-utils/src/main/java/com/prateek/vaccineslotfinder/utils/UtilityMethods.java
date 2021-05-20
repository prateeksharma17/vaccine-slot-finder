package com.prateek.vaccineslotfinder.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilityMethods {		
	
	private UtilityMethods() {
		//Private constructor to avoid instantiation
	}
	
	
	public static Map<String,String> getMonthsMap(){
		Map<String,String> monthsMap = new HashMap<>();
		monthsMap.put("January", "01");
		monthsMap.put("February", "02");
		monthsMap.put("March", "03");
		monthsMap.put("April", "04");
		monthsMap.put("May", "05");
		monthsMap.put("June", "06");
		monthsMap.put("July", "07");
		monthsMap.put("August", "08");
		monthsMap.put("September", "09");
		monthsMap.put("October", "10");
		monthsMap.put("November", "11");
		monthsMap.put("December", "12");
		
		return monthsMap;
	}
	
	
	public static boolean isNumber(String input) {
		if(input==null || input.isEmpty())
			return false;		
		
		return !(input.matches(".*\\D.*"));		
	}
	
	

	public static String getPONamesString(List<String> poNamesList, String pincode) {
		StringBuilder builder = new StringBuilder();
		builder.append("Pincode "+pincode+" covers ");
		for(String poNames : poNamesList) {
			builder.append(poNames+", ");
		}
		
		return builder.substring(0, builder.lastIndexOf(","));		
	}
	
	
	public static String getMonthNum(String month) {
		Map<String,String> monthsMap = getMonthsMap();
		
		return monthsMap.get(month);
	}


	public static String getSlotString(List<String> slots) {
		StringBuilder builder = new StringBuilder();
		
		for(String slot : slots) {
			builder.append(slot+"\n");
		}
		
		return builder.toString();
	}

}
