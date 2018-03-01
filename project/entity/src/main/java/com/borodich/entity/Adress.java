package com.borodich.entity;

import com.borodich.entity.api.AbstractBaseEntity;

public class Adress extends AbstractBaseEntity{

	private static final long serialVersionUID = 9035380868408172439L;
	private Long id;
	private String city;
	private String street;
	private String house;
	private String apartment;

	public Adress(){
	}
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}
}