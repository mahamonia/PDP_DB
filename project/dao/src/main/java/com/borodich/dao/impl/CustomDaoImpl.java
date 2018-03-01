package com.borodich.dao.impl;

import com.borodich.dao.api.CustomDao;
import com.borodich.entity.Custom;

public class CustomDaoImpl extends AbstractBaseDao<Custom> implements CustomDao {

	public CustomDaoImpl() {
		super(Custom.class);
	}
}