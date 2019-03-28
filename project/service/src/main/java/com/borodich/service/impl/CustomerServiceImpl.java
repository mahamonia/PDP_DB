package com.borodich.service.impl;

import com.borodich.dao.api.AdressDao;
import com.borodich.dao.api.ChekDao;
import com.borodich.dao.api.CustomerDao;
import com.borodich.dao.api.ProductDao;
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
    @Autowired
    private ProductDao productDao;
    @Autowired
    private AdressDao adressDao;

    @Override
    public void addChekToCustomer(Integer customerId, List<Integer> productsId, Integer adressId) {
	List<Product> products = new ArrayList<Product>();
	Double sum = 0.0;
	for (Integer id : productsId) {
	    Product product = productDao.getEntityById(id);
	    sum = + product.getPrice();
	    products.add(product);
	}
	Customer customer = customerDao.getEntityById(customerId);
	Chek chek = createNewChek(sum, customer, products, adressId);

	List<Chek> cheks = new ArrayList<Chek>();
	cheks.add(chek);
	customer.setCheks(cheks);

	customerDao.update(customer);
    }
    
    private Chek createNewChek(Double sum, Customer customer, List<Product> products, Integer adressId){
	Vendor vendor = vendorDao.getFreeVendor();
	vendor.setSatus(true);
	Adress adress = adressDao.getEntityById(adressId);
	Chek chek = chekDao.prepareNewChek(sum, customer, products, vendor, adress);
	chekDao.create(chek);
	return chek;
    }
}