package com.borodich.entity;

import com.borodich.entity.api.AbstractBaseEntity;

public class Vendor extends AbstractBaseEntity{
	private static final long serialVersionUID = 2243220376669935489L;
	private Long id;
	private Boolean satus;
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean isSatus() {
		return satus;
	}

	public void setSatus(Boolean satus) {
		this.satus = satus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
