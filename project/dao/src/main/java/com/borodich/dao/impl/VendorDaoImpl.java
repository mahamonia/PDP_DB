package com.borodich.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.borodich.dao.api.VendorDao;
import com.borodich.entity.Vendor;

@Repository
public class VendorDaoImpl extends AbstractBaseDao<Vendor> implements VendorDao{

	public VendorDaoImpl() {
		super(Vendor.class);
	}

	@Override
	public List<Vendor> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vendor getEntityById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}