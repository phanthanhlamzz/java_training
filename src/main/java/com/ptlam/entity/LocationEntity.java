package com.ptlam.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="location")
public class LocationEntity extends BaseEntity{
	@Id
	@Column(name="location_id")
	private UUID locationId;
	
	@Column(name="country")
	private String country;
	
	@Column(name="city")
	private String city;
	
	@OneToMany(mappedBy = "locationEntity",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	private Set<SaleEntity> saleEntities = new HashSet<SaleEntity>();

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

	public Set<SaleEntity> getSaleEntities() {
		return saleEntities;
	}

	public void setSaleEntities(Set<SaleEntity> saleEntities) {
		this.saleEntities = saleEntities;
	}
	
	
}
