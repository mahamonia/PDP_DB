package com.borodich.dao.impl;

import com.borodich.dao.api.ProductDao;
import com.borodich.entity.Product;

import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl extends AbstractBaseDao<Product> implements ProductDao {

    public ProductDaoImpl() {
	super(Product.class);
    }
}