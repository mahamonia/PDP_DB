package com.borodich.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.borodich.dao.api.AdressDao;
import com.borodich.entity.Adress;

@Repository
public class AdressDaoImpl extends AbstractBaseDao<Adress> implements AdressDao {

	public AdressDaoImpl() {
		super(Adress.class);
	}

	@Override
	public Adress getEntityById(Integer id) {
		return entityManager.find(Adress.class, id);
	}

	@Override
	public List<Adress> getAll() {
		return null;
	}
}