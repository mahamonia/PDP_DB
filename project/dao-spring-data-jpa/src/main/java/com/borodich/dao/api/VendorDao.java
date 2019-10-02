package com.borodich.dao.api;

import com.borodich.entity.Vendor;

import org.springframework.stereotype.Repository;
@Repository
public interface VendorDao extends BaseDao<Vendor> {
    
    public Vendor getFreeVendor();

}
