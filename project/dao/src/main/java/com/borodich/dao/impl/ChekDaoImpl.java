package com.borodich.dao.impl;

import com.borodich.dao.api.ChekDao;
import com.borodich.entity.Adress;
import com.borodich.entity.Chek;
import com.borodich.entity.Customer;
import com.borodich.entity.Product;

import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class ChekDaoImpl extends AbstractBaseDao<Chek> implements ChekDao {

    private static final String COLUMN_ID = "id";
    private static final String CHEK = "chek";

    public ChekDaoImpl() {
	super(Chek.class);
    }

    @Override
    public Chek prepareNewChek(Customer customer, List<Product> products, Adress adress) {
	Chek chek = new Chek(new Date());
	chek.setIsPaid(false);
	chek.setNumber(generatedNumber());
	chek.setCustomer(customer);
	chek.setProducts(products);
	chek.setAdress(adress);
	return chek;
    }

    private String generatedNumber() {
	List<Chek> cheks = getAll(COLUMN_ID);
	Chek chek = cheks.get(cheks.size() - 1);
	String chekNumber = chek.getNumber();
	String number = CHEK + String.valueOf(chekNumber.substring(4) + 1);
	return number;
    }
}