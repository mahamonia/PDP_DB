package com.borodich.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.borodich.dao.api.BrandDao;
import com.borodich.entity.Brand;

@Repository
public class BrandDaoImpl extends AbstractBaseDao<Brand> implements BrandDao {

	public BrandDaoImpl() {
		super(Brand.class);
	}

	@Override
	public Brand getEntityById(Integer id) {
		return entityManager.find(Brand.class, id);
	}

	@Override
	public List<Brand> getAll() {
		return null;
	}
}