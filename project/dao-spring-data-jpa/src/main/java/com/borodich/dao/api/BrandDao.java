package com.borodich.dao.api;

import com.borodich.entity.Brand;

import org.springframework.stereotype.Repository;
@Repository
public interface BrandDao extends BaseDao<Brand>{
    
    public Brand getBrandByTitle(String title);

}
