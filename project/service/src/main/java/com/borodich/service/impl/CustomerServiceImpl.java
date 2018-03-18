package com.borodich.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borodich.dao.api.CustomerDao;
import com.borodich.entity.Customer;
import com.borodich.service.api.CustomerService;

@Service
public class CustomerServiceImpl extends AbstractBaseService<Customer> implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	@Override
	public Customer getById(Integer id) {
		return customerDao.getEntityById(id);
	}

	@Override
	public List<Customer> getAll() {
		return null;
	}

}
