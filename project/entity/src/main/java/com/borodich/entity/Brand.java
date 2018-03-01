package com.borodich.entity;

import java.util.List;

import com.borodich.entity.api.AbstractBaseEntity;

public class Brand extends AbstractBaseEntity{
	private static final long serialVersionUID = -858215859123250928L;
	private Long id;
	private String title;
	private List<Product> products;
	
	public Brand() {
	}

	public Long getId() {
		return id;
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}