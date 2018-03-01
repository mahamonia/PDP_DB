package com.borodich.dao.impl;

import com.borodich.dao.api.CustomerDao;
import com.borodich.entity.Customer;

public class CustomerDaoImpl extends AbstractBaseDao<Customer> implements CustomerDao {

	public CustomerDaoImpl() {
		super(Customer.class);
	}
}
