package com.borodich.controller.api;

import java.util.Map;

public abstract class AbstractBaseController {
    protected static final String ID = "id";
    
    @SuppressWarnings("unchecked")
    protected Integer getIdFromRequest(Map<String, Object> request, String key){
	Map<String, Object> entityJson = (Map<String, Object>) request.get(key);
	Integer id = (Integer.valueOf((String)entityJson.get(ID)));
	return id;
    }
}