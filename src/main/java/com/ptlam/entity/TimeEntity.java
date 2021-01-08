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
@Table(name = "time")
public class TimeEntity extends BaseEntity{
	@Id
	@Column(name="time_id")
	private UUID timeId;
	
	@Column(name="month")
	private Integer month;
	
	@Column(name="quarter")
	private Integer quarter;
	
	@Column(name="year")
	private Integer year;

	@OneToMany(mappedBy = "timeEntity",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	private Set<SaleEntity> saleEntities = new HashSet<SaleEntity>();

	public UUID getTimeId() {
		return timeId;
	}

	public void setTimeId(UUID timeId) {
		this.timeId = timeId;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getQuarter() {
		return quarter;
	}

	public void setQuarter(Integer quarter) {
		this.quarter = quarter;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Set<SaleEntity> getSaleEntities() {
		return saleEntities;
	}

	public void setSaleEntities(Set<SaleEntity> saleEntities) {
		this.saleEntities = saleEntities;
	} 
	
	
}
