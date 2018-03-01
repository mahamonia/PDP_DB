package com.borodich.dao.impl;

import java.util.List;

import com.borodich.dao.api.BaseDao;
import com.borodich.entity.api.AbstractBaseEntity;

public abstract class AbstractBaseDao<T extends AbstractBaseEntity> implements BaseDao<T> {

	protected Class<T> clazz;

	public AbstractBaseDao(Class<T> clazz) {
		this.clazz = clazz;
	}

	public T getEntityById(Long id) {
		return null;
	}

	public void create(T entity) {
	}

	public void update(T entity) {
	}

	public void delete(T entity) {
	}

	public List<T> getAll() {
		return null;
	}
}