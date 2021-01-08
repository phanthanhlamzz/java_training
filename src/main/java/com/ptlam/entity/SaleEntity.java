package com.ptlam.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="sale")
public class SaleEntity extends BaseEntity{
	@Id
	@Column(name = "sale_id")
	private UUID saleId;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductEntity productEntity;
	
	@ManyToOne
	@JoinColumn(name = "time_id")
	private TimeEntity timeEntity;
	
	@ManyToOne
	@JoinColumn(name = "location_id")
	private LocationEntity locationEntity;
	
	@Column(name="dollars")
	private Integer dollars;

	public UUID getSaleId() {
		return saleId;
	}

	public void setSaleId(UUID saleId) {
		this.saleId = saleId;
	}

	public ProductEntity getProductEntity() {
		return productEntity;
	}

	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}

	public TimeEntity getTimeEntity() {
		return timeEntity;
	}

	public void setTimeEntity(TimeEntity timeEntity) {
		this.timeEntity = timeEntity;
	}

	public LocationEntity getLocationEntity() {
		return locationEntity;
	}

	public void setLocationEntity(LocationEntity locationEntity) {
		this.locationEntity = locationEntity;
	}

	public Integer getDollars() {
		return dollars;
	}

	public void setDollars(Integer dollars) {
		this.dollars = dollars;
	}

	
}
