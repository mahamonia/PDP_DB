package com.borodich.dao.impl;

import com.borodich.dao.api.AdressDao;
import com.borodich.entity.Adress;

public class AdressDaoImpl extends AbstractBaseDao<Adress> implements AdressDao {

	public AdressDaoImpl() {
		super(Adress.class);
	}
}