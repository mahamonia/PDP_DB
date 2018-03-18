package com.borodich.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.borodich.entity.api.AbstractBaseEntity;

@Entity
public class Brand extends AbstractBaseEntity{
	private static final long serialVersionUID = -858215859123250928L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="title")
	private String title;
	
	@OneToMany(mappedBy = "brand")
	private List<Product> products;
	
	public Brand() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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