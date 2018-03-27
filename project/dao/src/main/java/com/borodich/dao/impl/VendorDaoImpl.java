package com.borodich.dao.impl;

import com.borodich.dao.api.VendorDao;
import com.borodich.entity.Vendor;

import org.springframework.stereotype.Repository;

@Repository
public class VendorDaoImpl extends AbstractBaseDao<Vendor> implements VendorDao{

	public VendorDaoImpl() {
		super(Vendor.class);
	}
}