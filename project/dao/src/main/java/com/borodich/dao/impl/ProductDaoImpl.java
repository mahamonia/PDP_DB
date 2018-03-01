package com.borodich.dao.impl;

import com.borodich.dao.api.ProductDao;
import com.borodich.entity.Product;

public class ProductDaoImpl extends AbstractBaseDao<Product> implements ProductDao {

	public ProductDaoImpl(Class<Product> clazz) {
		super(clazz);
	}
}