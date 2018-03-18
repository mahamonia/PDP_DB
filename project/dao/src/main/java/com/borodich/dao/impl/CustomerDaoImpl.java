package com.borodich.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.borodich.dao.api.CustomerDao;
import com.borodich.entity.Customer;

@Repository
public class CustomerDaoImpl extends AbstractBaseDao<Customer> implements CustomerDao {

	public CustomerDaoImpl() {
		super(Customer.class);
	}

	public Customer getEntityById(Integer id) {
		return entityManager.find(Customer.class, id);
	}
	
	@Override
	public List<Customer> getAll() {
		return null;
	}
}