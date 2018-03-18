package com.borodich.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.borodich.dao.api.BaseDao;
import com.borodich.entity.api.AbstractBaseEntity;


public abstract class AbstractBaseDao<T extends AbstractBaseEntity> implements BaseDao<T> {

	protected Class<T> clazz;
	@PersistenceContext
	protected EntityManager entityManager;

	public AbstractBaseDao(Class<T> clazz) {
		this.clazz = clazz;
	}

	public void create(T entity) {
		entityManager.persist(entity);
	}

	public void update(T entity) {
		entityManager.refresh(entity);
	}

	public void delete(T entity) {
		entityManager.remove(entity);
	}
}