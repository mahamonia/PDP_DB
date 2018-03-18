package com.borodich.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.borodich.dao.api.ProductDao;
import com.borodich.entity.Product;

@Repository
public class ProductDaoImpl extends AbstractBaseDao<Product> implements ProductDao {

	public ProductDaoImpl() {
		super(Product.class);
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getEntityById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}