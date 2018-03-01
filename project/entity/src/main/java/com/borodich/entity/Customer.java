package com.borodich.entity;

import java.util.List;

import com.borodich.entity.api.AbstractBaseEntity;

public class Customer extends AbstractBaseEntity{

	private static final long serialVersionUID = -8335190571849701588L;
	private Long id;
	private String name;
	private String surname;
	
	private List<Custom> customs;

	public Customer(){
	}
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Custom> getCustoms() {
		return customs;
	}

	public void setCustoms(List<Custom> customs) {
		this.customs = customs;
	}
}