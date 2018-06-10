package com.borodich.service.impl;

import com.borodich.dao.api.VendorDao;
import com.borodich.entity.Vendor;
import com.borodich.service.api.VendorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorServiceImpl extends AbstractBaseService<Vendor> implements VendorService{
    @Autowired
    private VendorDao vendorDao;

    @Override
    public Vendor getFreeVendor() {
	return vendorDao.getFreeVendor();
    }

}
