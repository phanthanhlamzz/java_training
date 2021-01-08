package com.ptlam.dto;

import java.util.UUID;

public class LocationDTO extends BaseDTO{
	private UUID locationId;
	private String country;
	private String city;
	
	public UUID getLocationId() {
		return locationId;
	}
	public void setLocationId(UUID locationId) {
		this.locationId = locationId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
}
