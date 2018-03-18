package com.borodich.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.borodich.entity.Customer;
import com.borodich.service.api.CustomerService;

@RestController
@RequestMapping("e-shop")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	public CustomerController() {
	}
	
	@GetMapping("customer/{id}")
	public String getArticleById(@PathVariable("id") Integer id) {
		Customer customer = customerService.getById(id);
		return customer.getName();
	}
}