package com.borodich.controller;

import com.borodich.entity.api.AbstractBaseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@RequestMapping(value = "e-shop", produces = "application/json")
public abstract class AbstractBaseController<T extends AbstractBaseEntity>{

    protected static final String ID = "id";
    
    public abstract @ResponseBody Map<String, Object> getEntityById(@PathVariable(ID) Integer id);
    public abstract @ResponseBody Map<String, Object> getEntities();
    public abstract @ResponseBody Map<String, Object> createEntity(@RequestBody T entity);
    public abstract @ResponseBody Map<String, Object> deleteEntity(@RequestBody T entity);
    public abstract @ResponseBody Map<String, Object> updateEntity(@RequestBody T entity);
    
    
    @SuppressWarnings("unchecked")
    protected Integer getIdFromRequest(Map<String, Object> request, String key){
	Map<String, Object> entityJson = (Map<String, Object>) request.get(key);
	Integer id = (Integer.valueOf((String)entityJson.get(ID)));
	return id;
    }
}