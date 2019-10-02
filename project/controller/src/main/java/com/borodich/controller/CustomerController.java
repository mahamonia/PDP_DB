package com.borodich.controller;

import com.borodich.entity.Customer;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CustomerController extends AbstractBaseController<Customer>{

    @Autowired
    private CustomerService customerService;
    @Autowired
    private ChekService chekService;
    @Autowired
    private AdressService adressService;
    @Autowired
    private ProductService productService;

    @Override
    @GetMapping("customer/{id}")
    public @ResponseBody Map<String, Object> getEntityById(@PathVariable(ID) Integer id) {
	Customer customer = customerService.getById(id);
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", customer);
	return result;
    }

    @Override
    @GetMapping("customers/")
    public @ResponseBody Map<String, Object> getEntities() {
	List<Customer> customers = customerService.getAll();
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", customers);
	return result;
    }

    @Override
    @PostMapping("customer/")
    public @ResponseBody Map<String, Object> createEntity(@RequestBody Customer entity) {
	Map<String, Object> result = new HashMap<String, Object>();
	customerService.create(entity);
	result.put("result", "created");
	return result;
    }

    @Override
    @DeleteMapping("customer/{id}")
    public @ResponseBody Map<String, Object> deleteEntity(@PathVariable Integer id) {
	Map<String, Object> result = new HashMap<String, Object>();
	customerService.delete(id);
	result.put("result", "deleted");
	return result;
    }

    @Override
    @PutMapping("customer/")
    public @ResponseBody Map<String, Object> updateEntity(@RequestBody Customer entity) {
	Map<String, Object> result = new HashMap<String, Object>();
	customerService.update(entity);
	result.put("result", entity);
	return result;
    }
    
    @PostMapping("customer/chek")
    public @ResponseBody Map<String, Object> addChek(@RequestParam(name="customerId") Integer customerId,  @RequestParam(name = "productsId") List<Integer> productsId, @RequestParam(name ="adressId" ) Integer adressId) {
	customerService.addChekToCustomer(customerId, productsId, adressId);
   	Map<String, Object> result = new HashMap<String, Object>();
   	result.put("result", "chek was added");
   	return result;
       }
}