package com.borodich.dao.api;

import java.util.List;

import com.borodich.entity.api.BaseEntity;

public interface BaseDao<T extends BaseEntity> {
	
	public T getEntityById(Long id);
	
	public void create (T entity);
	
	public void update (T entity);
	
	public void delete (T entity);
	
	public List<T> getAll();
	
}
