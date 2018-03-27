package com.borodich.dao.impl;

import com.borodich.dao.api.BaseDao;
import com.borodich.entity.api.AbstractBaseEntity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


public abstract class AbstractBaseDao<T extends AbstractBaseEntity> implements BaseDao<T> {
	private String queryFormat = "SELECT entity FROM %s entity";
    	
	protected Class<T> clazz;
	@PersistenceContext
	protected EntityManager entityManager;
	
	public AbstractBaseDao(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public T getEntityById(Integer id) {
		return entityManager.find(clazz, id);
	}

	@Override
	public void create(T entity) {
		entityManager.persist(entity);
	}

	@Override
	public void update(T entity) {
		entityManager.refresh(entity);
	}

	@Override
	public void delete(T entity) {
		entityManager.remove(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
	    String table = clazz.getSimpleName();
	    String querySql = String.format(queryFormat, table);
	    Query query = entityManager.createQuery(querySql);
	    return query.getResultList();
	}
	
}