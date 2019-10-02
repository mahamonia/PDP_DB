package com.borodich.dao.api;

import com.borodich.entity.api.AbstractBaseEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BaseDao<T extends AbstractBaseEntity> extends JpaRepository<T, Integer> {
    
    public T findById(Integer id);
}
