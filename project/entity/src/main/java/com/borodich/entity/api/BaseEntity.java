package com.borodich.entity.api;

import java.io.Serializable;

public interface BaseEntity extends Serializable {

	public Long getId();
	public void setId(Long id);
}