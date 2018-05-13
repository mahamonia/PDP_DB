package com.borodich.controller;

import com.borodich.controller.api.AbstractBaseController;
import com.borodich.entity.Product;
import com.borodich.service.api.ProductService;

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
public class ProductController extends AbstractBaseController{
    @Autowired
    private ProductService productService;

    @GetMapping("product/{id}")
    public @ResponseBody Map<String, Object> getEntityById(@PathVariable(ID) Integer id) {
	Product product = productService.getById(id);
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", product);
	return result;
    }

    @GetMapping("products/")
    public @ResponseBody Map<String, Object> getEntities() {
	List<Product> products = productService.getAll();
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", products);
	return result;
    }

    @PostMapping("product/")
    public @ResponseBody Map<String, Object> createEntity(@RequestBody Product entity) {
	Map<String, Object> result = new HashMap<String, Object>();
	productService.create(entity);
	result.put("result", "created");
	return result;
    }

    @DeleteMapping("product/")
    public @ResponseBody Map<String, Object> deleteEntity(@RequestBody Product entity) {
	Map<String, Object> result = new HashMap<String, Object>();
	productService.delete(entity);
	result.put("result", "deleted");
	return result;
    }

    @PutMapping("product/")
    public @ResponseBody Map<String, Object> updateEntity(@RequestBody Product entity) {
	Map<String, Object> result = new HashMap<String, Object>();
	productService.update(entity);
	result.put("result", entity);
	return result;
    }
}
