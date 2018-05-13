package com.borodich.controller;

import com.borodich.controller.api.AbstractBaseController;
import com.borodich.entity.Brand;
import com.borodich.service.api.BrandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("e-shop")
public class BrandController extends AbstractBaseController{
    
    @Autowired
    private BrandService brandService;

    @GetMapping("brand/{id}")
    public @ResponseBody Map<String, Object> getEntityById(@PathVariable(ID) Integer id) {
	Brand brand = brandService.getById(id);
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", brand);
	return result;
    }

    @GetMapping("brands/")
    public @ResponseBody Map<String, Object> getEntities() {
	List<Brand> brands = brandService.getAll();
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", brands);
	return result;
    }

    @PostMapping("brand/")
    public @ResponseBody Map<String, Object> createEntity(@RequestBody Brand entity) {
	Map<String, Object> result = new HashMap<String, Object>();
	brandService.create(entity);
	result.put("result", "created");
	return result;
    }

    @DeleteMapping("brand/")
    public @ResponseBody Map<String, Object> deleteEntity(@RequestBody Brand entity) {
	Map<String, Object> result = new HashMap<String, Object>();
	brandService.delete(entity);
	result.put("result", "deleted");
	return result;
    }

    @PutMapping("brand/")
    public @ResponseBody Map<String, Object> updateEntity(@RequestBody Brand entity) {
	Map<String, Object> result = new HashMap<String, Object>();
	brandService.update(entity);
	result.put("result", entity);
	return result;
    }
}