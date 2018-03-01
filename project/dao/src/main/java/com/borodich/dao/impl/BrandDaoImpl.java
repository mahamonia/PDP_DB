package com.borodich.dao.impl;

import com.borodich.dao.api.BrandDao;
import com.borodich.entity.Brand;

public class BrandDaoImpl extends AbstractBaseDao<Brand> implements BrandDao {

	public BrandDaoImpl() {
		super(Brand.class);
	}
}