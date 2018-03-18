package com.borodich.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.borodich.dao.api.ChekDao;
import com.borodich.entity.Chek;

@Repository
public class ChekDaoImpl extends AbstractBaseDao<Chek> implements ChekDao {

	public ChekDaoImpl() {
		super(Chek.class);
	}

	@Override
	public List<Chek> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chek getEntityById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}