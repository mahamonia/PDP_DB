package com.borodich.entity;

import java.util.Date;
import java.util.List;

import com.borodich.entity.api.AbstractBaseEntity;

public class Product extends AbstractBaseEntity{

	private static final long serialVersionUID = -1962662067708450327L;
	private Long id;
	private String title;
	private String price;
	private String description;
	private Date expiryDate;
	private Section section;
	private Brand brand;
	private List<Custom> customs;

	public Product(){
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public List<Custom> getCustoms() {
		return customs;
	}

	public void setCustoms(List<Custom> customs) {
		this.customs = customs;
	}
}