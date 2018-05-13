package com.borodich.controller;

import com.borodich.controller.api.AbstractBaseController;
import com.borodich.entity.Adress;
import com.borodich.entity.Customer;
import com.borodich.entity.Product;
import com.borodich.service.api.AdressService;
import com.borodich.service.api.ChekService;
import com.borodich.service.api.CustomerService;
import com.borodich.service.api.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "e-shop", produces = "application/json")
public class CustomerController extends AbstractBaseController{

    private static final String ADRESS = "adress";
    private static final String PRODUCTS = "products";
    private static final String CUSTOMER = "customer";

    @Autowired
    private CustomerService customerService;
    @Autowired
    private ChekService chekService;
    @Autowired
    private AdressService adressService;
    @Autowired
    private ProductService productService;

    @GetMapping("customer/{id}")
    public @ResponseBody Map<String, Object> getEntityById(@PathVariable(ID) Integer id) {
	Customer customer = customerService.getById(id);
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", customer);
	return result;
    }

    @GetMapping("customers/")
    public @ResponseBody Map<String, Object> getEntities() {
	List<Customer> customers = customerService.getAll();
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", customers);
	return result;
    }

    @PostMapping("customer/")
    public @ResponseBody Map<String, Object> createEntity(@RequestBody Customer entity) {
	Map<String, Object> result = new HashMap<String, Object>();
	customerService.create(entity);
	result.put("result", "created");
	return result;
    }

    @DeleteMapping("customer/")
    public @ResponseBody Map<String, Object> deleteEntity(@RequestBody Customer entity) {
	Map<String, Object> result = new HashMap<String, Object>();
	customerService.delete(entity);
	result.put("result", "deleted");
	return result;
    }

    @PutMapping("customer/")
    public @ResponseBody Map<String, Object> updateEntity(@RequestBody Customer entity) {
	Map<String, Object> result = new HashMap<String, Object>();
	customerService.update(entity);
	result.put("result", entity);
	return result;
    }
    
    @SuppressWarnings("unchecked")
    @PostMapping("customer/chek")
    public @ResponseBody Map<String, Object> addChek(@RequestBody Object request) {

	Integer customerId =  getIdFromRequest((Map<String, Object>)request, CUSTOMER);
	Customer customer = customerService.getById(customerId);
	
	List<Product> products = new ArrayList<Product>();
	List<Object> entities = (List<Object>) ((Map<String, Object>)request).get(PRODUCTS);
	for (Object entity : entities) {
	    Map<String, Object> productTemp = (Map<String, Object>)entity;
	    Integer id = (Integer.valueOf((String)productTemp.get(ID)));
	    Product product = productService.getById(id);
	    products.add(product);
	}
	
	Integer adressId = getIdFromRequest((Map<String, Object>)request, ADRESS);
	Adress adress = adressService.getById(adressId);
	
	customerService.addChekToCustomer(customer, products, adress);
	
   	Map<String, Object> result = new HashMap<String, Object>();
   	result.put("result", "chek was added");
   	return result;
       }
}