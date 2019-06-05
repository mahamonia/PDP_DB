package com.borodich.dao.impl;

import com.borodich.dao.api.AdressDao;
import com.borodich.entity.Adress;

import org.springframework.stereotype.Repository;

@Repository
public class AdressDaoImpl extends AbstractBaseDao<Adress> implements AdressDao {

    public AdressDaoImpl() {
	super(Adress.class);
    }
}