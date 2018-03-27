package com.borodich.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.borodich.dao.api.BaseDao;
import com.borodich.entity.api.AbstractBaseEntity;
import com.borodich.service.api.BaseService;

public abstract class AbstractBaseService<T extends AbstractBaseEntity> implements BaseService<T> {

	@Autowired
	private BaseDao<T> dao;

	@Override
	public void create(T entity) {
		dao.create(entity);
	}

	@Override
	public void update(T entity) {
		dao.update(entity);
	}

	@Override
	public void delete(T entity) {
		dao.delete(entity);
	}
	@Override
	public T getById(Integer id) {
		return dao.getEntityById(id);
	}

	@Override
	public List<T> getAll() {
		return dao.getAll();
	}
}