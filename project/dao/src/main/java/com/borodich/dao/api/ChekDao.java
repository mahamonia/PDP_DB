package com.borodich.dao.api;

import com.borodich.entity.Adress;
import com.borodich.entity.Chek;
import com.borodich.entity.Customer;
import com.borodich.entity.Product;

import java.util.List;

public interface ChekDao extends BaseDao<Chek>{
    
    public Chek prepareNewChek(Customer customer, List<Product> products, Adress adress);

}
