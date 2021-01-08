package com.ptlam.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class ProductEntity extends BaseEntity{
	@Id
	@Column(name = "product_id")
	private UUID productId;
	
	@Column(name = "item")
	private Integer item;
	
	@Column(name= "class")
	private String zclass;
	
	@Column(name="inventory")
	private String inventory;

	@OneToMany(mappedBy = "productEntity",fetch = FetchType.LAZY)
	private Set<SaleEntity> saleEntities = new HashSet<SaleEntity>();

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

	public Set<SaleEntity> getSaleEntities() {
		return saleEntities;
	}

	public void setSaleEntities(Set<SaleEntity> saleEntities) {
		this.saleEntities = saleEntities;
	}
	
	
}
