package com.borodich.dao.impl;

import com.borodich.dao.api.BaseDao;
import com.borodich.entity.api.AbstractBaseEntity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public abstract class AbstractBaseDao<T extends AbstractBaseEntity> implements BaseDao<T> {
    private static final String COLUMN_ID = "id";

    private String queryFormat = "SELECT entity FROM %s entity ORDER BY %s";

    protected Class<T> clazz;
    @PersistenceContext
    protected EntityManager entityManager;

    public AbstractBaseDao(Class<T> clazz) {
	this.clazz = clazz;
    }

    protected CriteriaBuilder getCriteriaBuilder() {
	return entityManager.getCriteriaBuilder();
    }

    protected CriteriaQuery<T> getCriteriaQuery() {
	return (CriteriaQuery<T>) getCriteriaBuilder().createQuery(clazz);
    }

    protected TypedQuery<T> getTypedQuery(CriteriaQuery<T> criteriaQuery) {
	return (TypedQuery<T>) entityManager.createQuery(criteriaQuery);
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
	entity = entityManager.contains(entity) ? entity : entityManager.merge(entity);
	entityManager.remove(entity);
    }

    @Override
    public List<T> getAll(String orderBy) {
	String table = clazz.getSimpleName();
	if (orderBy == null || orderBy.isEmpty()) {
	    orderBy = COLUMN_ID;
	}
	String querySql = String.format(queryFormat, table, orderBy);
	TypedQuery<T> query = entityManager.createQuery(querySql, clazz);
	return query.getResultList();
    }

}