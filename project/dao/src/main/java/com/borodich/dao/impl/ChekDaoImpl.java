package com.borodich.dao.impl;

import com.borodich.dao.api.ChekDao;
import com.borodich.entity.Chek;

import org.springframework.stereotype.Repository;

@Repository
public class ChekDaoImpl extends AbstractBaseDao<Chek> implements ChekDao {

	public ChekDaoImpl() {
		super(Chek.class);
	}
}