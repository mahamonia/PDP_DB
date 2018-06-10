package com.borodich.service.api;

import com.borodich.entity.Adress;
import com.borodich.entity.Customer;
import com.borodich.entity.Product;

import java.util.List;

public interface CustomerService extends BaseService<Customer>{
    
    public void addChekToCustomer(Integer customer, List<Integer> products, Integer adress);

}
