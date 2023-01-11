package com.luv2code.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fertility_rate")
public class FertilityRate {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public int id;
	
	@Column(name="rate")
	public double rate;
	
	@Column(name="state_name")
	public String stateName;
	
	@Column(name="country_name")
	public String countryName;
	
	public FertilityRate() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		return "FertilityRate [id=" + id + ", rate=" + rate + ", stateName=" + stateName + ", countryName="
				+ countryName + "]";
	}

	public FertilityRate(double rate, String stateName, String countryName) {
		this.rate = rate;
		this.stateName = stateName;
		this.countryName = countryName;
	}
	
	
}
