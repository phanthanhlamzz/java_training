package com.ptlam.dto;


import java.util.UUID;

public class SaleDTO extends BaseDTO{
	private UUID saleId;
	private UUID productId;
	private UUID timeId;
	private UUID locationId;
	private Integer dollars;
	
	
	public UUID getSaleId() {
		return saleId;
	}
	public void setSaleId(UUID saleId) {
		this.saleId = saleId;
	}
	public UUID getProductId() {
		return productId;
	}
	public void setProductId(UUID productId) {
		this.productId = productId;
	}
	public UUID getTimeId() {
		return timeId;
	}
	public void setTimeId(UUID timeId) {
		this.timeId = timeId;
	}
	public UUID getLocationId() {
		return locationId;
	}
	public void setLocationId(UUID locationId) {
		this.locationId = locationId;
	}
	public Integer getDollars() {
		return dollars;
	}
	public void setDollars(Integer dollars) {
		this.dollars = dollars;
	}
	
	
	
}
