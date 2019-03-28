package com.borodich.controller;

import com.borodich.entity.Brand;
import com.borodich.service.api.BrandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BrandController extends AbstractBaseController<Brand>{

    @Autowired
    private BrandService brandService;

    @Override
    @GetMapping("brand/{id}")
    public @ResponseBody Map<String, Object> getEntityById(@PathVariable(ID) Integer id) {
	Brand brand = brandService.getById(id);
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", brand);
	return result;
    }

    @Override
    @GetMapping("brands/")
    public @ResponseBody Map<String, Object> getEntities() {
	List<Brand> brands = brandService.getAll(ID);
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", brands);
	return result;
    }

    @Override
    @PostMapping("brand/")
    public @ResponseBody Map<String, Object> createEntity(@RequestBody Brand entity) {
	Map<String, Object> result = new HashMap<String, Object>();
	brandService.create(entity);
	result.put("result", "created");
	return result;
    }

    @Override
    @PatchMapping("brand/")
    public @ResponseBody Map<String, Object> deleteEntity(@RequestBody Brand entity) {
	Map<String, Object> result = new HashMap<String, Object>();
	brandService.delete(entity);
	result.put("result", "deleted");
	return result;
    }

    @Override
    @PutMapping("brand/")
    public @ResponseBody Map<String, Object> updateEntity(@RequestBody Brand entity) {
	Map<String, Object> result = new HashMap<String, Object>();
	brandService.update(entity);
	result.put("result", entity);
	return result;
    }
    
    @GetMapping("brand/")
    public Map<String, Object> getBrandByTitle(@RequestParam String title){
	Map<String, Object> result = new HashMap<String, Object>();
	Brand brand = brandService.getBrandByTitle(title);
	result.put("result", brand);
	return result;
    }
}