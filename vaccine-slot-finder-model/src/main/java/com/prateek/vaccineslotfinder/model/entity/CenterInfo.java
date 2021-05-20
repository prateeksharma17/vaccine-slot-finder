package com.prateek.vaccineslotfinder.model.entity;

import java.util.List;

public class CenterInfo {
	
	private Integer center_id;
	private String name;
	private String name_1;
	private String address;
	private String address_1;
	private String state_name;
	private String state_name_1;
	private String district_name;
	private String district_name_1;
	private String block_name;
	private String block_name_1;
	private Integer pincode;
	private Float lat;
	private Float lon;
	private String from;
	private String to;
	private String fee_type;
	private String fee;
	private String session_id;
	private String date;
	private Integer available_capacity_dose1;
	private Integer available_capacity_dose2;
	private Integer available_capacity;
	private Integer min_age_limit;
	private String vaccine;
	private List<String> slots;
	
	
	public Integer getPincode() {
		return pincode;
	}


	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}


	public Integer getAvailable_capacity_dose1() {
		return available_capacity_dose1;
	}


	public void setAvailable_capacity_dose1(Integer available_capacity_dose1) {
		this.available_capacity_dose1 = available_capacity_dose1;
	}


	public Integer getAvailable_capacity_dose2() {
		return available_capacity_dose2;
	}


	public void setAvailable_capacity_dose2(Integer available_capacity_dose2) {
		this.available_capacity_dose2 = available_capacity_dose2;
	}	
	
	
	public CenterInfo() {
		// Default Constructor
	}    
	

	public CenterInfo(Integer center_id, String name, String name_1, String address, String address_1,
			String state_name, String state_name_1, String district_name, String district_name_1, String block_name,
			String block_name_1, Integer pincode, Float lat, Float lon, String from, String to, String fee_type,
			String fee, String session_id, String date, Integer available_capacity_dose1,
			Integer available_capacity_dose2, Integer available_capacity, Integer min_age_limit, String vaccine,
			List<String> slots) {		
		this.center_id = center_id;
		this.name = name;
		this.name_1 = name_1;
		this.address = address;
		this.address_1 = address_1;
		this.state_name = state_name;
		this.state_name_1 = state_name_1;
		this.district_name = district_name;
		this.district_name_1 = district_name_1;
		this.block_name = block_name;
		this.block_name_1 = block_name_1;
		this.pincode = pincode;
		this.lat = lat;
		this.lon = lon;
		this.from = from;
		this.to = to;
		this.fee_type = fee_type;
		this.fee = fee;
		this.session_id = session_id;
		this.date = date;
		this.available_capacity_dose1 = available_capacity_dose1;
		this.available_capacity_dose2 = available_capacity_dose2;
		this.available_capacity = available_capacity;
		this.min_age_limit = min_age_limit;
		this.vaccine = vaccine;
		this.slots = slots;
	}




	public Integer getCenter_id() {
		return center_id;
	}


	public void setCenter_id(Integer center_id) {
		this.center_id = center_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getName_1() {
		return name_1;
	}


	public void setName_1(String name_1) {
		this.name_1 = name_1;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getAddress_1() {
		return address_1;
	}


	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}


	public String getState_name() {
		return state_name;
	}


	public void setState_name(String state_name) {
		this.state_name = state_name;
	}


	public String getState_name_1() {
		return state_name_1;
	}


	public void setState_name_1(String state_name_1) {
		this.state_name_1 = state_name_1;
	}


	public String getDistrict_name() {
		return district_name;
	}


	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}


	public String getDistrict_name_1() {
		return district_name_1;
	}


	public void setDistrict_name_1(String district_name_1) {
		this.district_name_1 = district_name_1;
	}


	public String getBlock_name() {
		return block_name;
	}


	public void setBlock_name(String block_name) {
		this.block_name = block_name;
	}


	public String getBlock_name_1() {
		return block_name_1;
	}


	public void setBlock_name_1(String block_name_1) {
		this.block_name_1 = block_name_1;
	}
	

	public Float getLat() {
		return lat;
	}


	public void setLat(Float lat) {
		this.lat = lat;
	}


	public Float getLon() {
		return lon;
	}


	public void setLon(Float lon) {
		this.lon = lon;
	}


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	public String getFee_type() {
		return fee_type;
	}


	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}


	public String getFee() {
		return fee;
	}


	public void setFee(String fee) {
		this.fee = fee;
	}


	public String getSession_id() {
		return session_id;
	}


	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public Integer getAvailable_capacity() {
		return available_capacity;
	}


	public void setAvailable_capacity(Integer available_capacity) {
		this.available_capacity = available_capacity;
	}


	public Integer getMin_age_limit() {
		return min_age_limit;
	}


	public void setMin_age_limit(Integer min_age_limit) {
		this.min_age_limit = min_age_limit;
	}


	public String getVaccine() {
		return vaccine;
	}


	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}


	public List<String> getSlots() {
		return slots;
	}


	public void setSlots(List<String> slots) {
		this.slots = slots;
	}


	@Override
	public String toString() {
		return "CenterInfo [center_id=" + center_id + ", name=" + name + ", name_1=" + name_1 + ", address=" + address
				+ ", address_1=" + address_1 + ", state_name=" + state_name + ", state_name_1=" + state_name_1
				+ ", district_name=" + district_name + ", district_name_1=" + district_name_1 + ", block_name="
				+ block_name + ", block_name_1=" + block_name_1 + ", pincode=" + pincode + ", lat=" + lat + ", lon="
				+ lon + ", from=" + from + ", to=" + to + ", fee_type=" + fee_type + ", fee=" + fee + ", session_id="
				+ session_id + ", date=" + date + ", available_capacity_dose1=" + available_capacity_dose1
				+ ", available_capacity_dose2=" + available_capacity_dose2 + ", available_capacity="
				+ available_capacity + ", min_age_limit=" + min_age_limit + ", vaccine=" + vaccine + ", slots=" + slots
				+ "]";
	}	

}
