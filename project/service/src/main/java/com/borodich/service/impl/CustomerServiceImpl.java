package com.borodich.service.impl;

import com.borodich.dao.api.ChekDao;
import com.borodich.dao.api.CustomerDao;
import com.borodich.dao.api.VendorDao;
import com.borodich.entity.Adress;
import com.borodich.entity.Chek;
import com.borodich.entity.Customer;
import com.borodich.entity.Product;
import com.borodich.entity.Vendor;
import com.borodich.service.api.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl extends AbstractBaseService<Customer> implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private VendorDao vendorDao;
    @Autowired
    private ChekDao chekDao;

    @Override
    public void addChekToCustomer(Customer customer, List<Product> products, Adress adress) {
	Chek chek = chekDao.prepareNewChek(customer, products, adress);

	Vendor vendor = vendorDao.getFreeVendor();
	chek.setVendor(vendor);

	chekDao.create(chek);

	List<Chek> cheks = new ArrayList<Chek>();
	cheks.add(chek);
	customer.setCheks(cheks);

	customerDao.update(customer);
    }
}