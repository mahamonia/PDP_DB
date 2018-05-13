package com.borodich.dao.api;

import com.borodich.entity.Vendor;

public interface VendorDao extends BaseDao<Vendor> {
    
    public Vendor getFreeVendor();

}
