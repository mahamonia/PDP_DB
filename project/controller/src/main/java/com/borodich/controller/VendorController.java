package com.borodich.controller;

import com.borodich.entity.Vendor;
import com.borodich.service.api.VendorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class VendorController extends AbstractBaseController{
    
    @Autowired
    private VendorService vendorService;

    @GetMapping("vendor/{id}")
    public @ResponseBody Map<String, Object> getEntityById(@PathVariable(ID) Integer id) {
	Vendor vendor = vendorService.getById(id);
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", vendor);
	return result;
    }

    @GetMapping("vendors/")
    public @ResponseBody Map<String, Object> getEntities() {
	List<Vendor> vendor = vendorService.getAll(ID);
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", vendor);
	return result;
    }

    @PostMapping("vendor/")
    public @ResponseBody Map<String, Object> createEntity(@RequestBody Vendor entity) {
	Map<String, Object> result = new HashMap<String, Object>();
	vendorService.create(entity);
	result.put("result", "created");
	return result;
    }

    @DeleteMapping("vendor/")
    public @ResponseBody Map<String, Object> deleteEntity(@RequestBody Vendor entity) {
	Map<String, Object> result = new HashMap<String, Object>();
	vendorService.delete(entity);
	result.put("result", "deleted");
	return result;
    }

    @PutMapping("vendor/")
    public @ResponseBody Map<String, Object> updateEntity(@RequestBody Vendor entity) {
	Map<String, Object> result = new HashMap<String, Object>();
	vendorService.update(entity);
	result.put("result", entity);
	return result;
    }
    
    @GetMapping("vendor/free")
    public @ResponseBody Map<String, Object> getFreeVendor() {
	Map<String, Object> result = new HashMap<String, Object>();
	Vendor freeVendor = vendorService.getFreeVendor();
	result.put("result", freeVendor);
	return result;
    }
}