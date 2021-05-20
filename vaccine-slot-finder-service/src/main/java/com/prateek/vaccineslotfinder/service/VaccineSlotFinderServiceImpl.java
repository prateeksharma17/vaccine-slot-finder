package com.prateek.vaccineslotfinder.service;

import java.io.IOException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.prateek.vaccineslotfinder.model.entity.PinCodeResponse;
import com.prateek.vaccineslotfinder.model.entity.PostOffice;
import com.prateek.vaccineslotfinder.model.entity.Sessions;
import com.prateek.vaccineslotfinder.utils.AppStringUtils;
import com.prateek.vaccineslotfinder.utils.UtilityMethods;

@Service
public class VaccineSlotFinderServiceImpl implements VaccineSlotFinderService {
	
	private static final Logger LOG = LoggerFactory.getLogger(VaccineSlotFinderServiceImpl.class);

	public Sessions findByPincode(String pincode, String date) {
		Sessions centersInfoList = null;
		
		try {			
			String url = AppStringUtils.FIND_BY_PINCODE_LINK.getString();
			url = url.replace("$PIN$", pincode);
			url = url.replace("$DATE$", date);			
			url = url.trim();
			
			String data =  Jsoup.connect(url).userAgent(AppStringUtils.USER_AGENT.getString()).ignoreContentType(true).execute().body();
			
			Gson gson = new Gson();
			centersInfoList = gson.fromJson(data, Sessions.class);
			
			LOG.info("Response received :");
			LOG.info(centersInfoList.toString());			
			
		}catch(IOException io) {
			LOG.error(io.getCause().getMessage());
		}catch(Exception ex) {
			LOG.error(ex.getCause().getMessage());
		}
		
		return centersInfoList;
	}

	
	public List<String> getListOfMonths() {
		List<String> monthsList = new ArrayList<>();
		String[] months = new DateFormatSymbols().getMonths();
		for(int i=0; i<months.length;i++) {
			monthsList.add(months[i]);
		}
		
		return monthsList;
	}


	@Override
	public List<String> getListOfDates() {
		List<String> datesList = new ArrayList<>();
		for(int i=1;i<=31;i++) {
			datesList.add(String.valueOf(i));
		}
		return datesList;
	}


	@Override
	public PinCodeResponse getListOfPOFromPinCode(String pincode) {
		PinCodeResponse pinCodeResponse = null;
		
		try {			
			String url = AppStringUtils.PINCODE_API_LINK.getString();
			url = url.replace("$PIN$", pincode);
						
			LOG.info("Hitting URL : "+url);			
			String data =  Jsoup.connect(url).execute().body();
			
			int index = data.indexOf('[');
			data = data.substring(index+1);
			
			index = data.lastIndexOf(']');
			data = data.substring(0, index);			
			
			data = data.trim();
			
			Gson gson = new Gson();
			pinCodeResponse = gson.fromJson(data, PinCodeResponse.class);
			
			LOG.info("Response received :");
			LOG.info(pinCodeResponse.toString());			
			
		}catch(IOException io) {
			LOG.error(io.getCause().getMessage());
		}catch(Exception ex) {
			LOG.error(ex.getCause().getMessage());
		}
		
		if(pinCodeResponse.getStatus().equalsIgnoreCase(AppStringUtils.ERROR.getString())) 
			return null;		
		
		return pinCodeResponse;		
	}


	@Override
	public List<String> getListOfPONames(List<PostOffice> postOfficeList) {
		List<String> poNamesList = null;
		if(postOfficeList!=null && !postOfficeList.isEmpty()) {
			poNamesList = new ArrayList<>();
			for(PostOffice postOffice : postOfficeList) {
				poNamesList.add(postOffice.getName());				
			}			
		}
		
		return poNamesList;
	}


	@Override
	public String getDateString(String day, String month, String year) {
		StringBuilder builder = new StringBuilder();
		
		if(Integer.parseInt(day)<10)
			builder.append("0"+day);
		else
			builder.append(day);
		
		builder.append("-");
		
		builder.append(UtilityMethods.getMonthNum(month));
		
		builder.append("-"+year);
		
		return builder.toString();		
	}

}
