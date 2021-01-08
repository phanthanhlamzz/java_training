package com.ptlam.dto;

import java.util.UUID;

public class ProductDTO extends BaseDTO {
	private UUID productId;
	private Integer item=0;
	private String zclass;
	private String inventory;
	public UUID getProductId() {
		return productId;
	}
	public void setProductId(UUID productId) {
		this.productId = productId;
	}
	public Integer getItem() {
		return item;
	}
	public void setItem(Integer item) {
		this.item = item;
	}
	public String getZclass() {
		return zclass;
	}
	public void setZclass(String zclass) {
		this.zclass = zclass;
	}
	public String getInventory() {
		return inventory;
	}
	public void setInventory(String inventory) {
		this.inventory = inventory;
	}
	
	
}
