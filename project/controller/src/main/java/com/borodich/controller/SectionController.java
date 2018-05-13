package com.borodich.controller;

import com.borodich.controller.api.AbstractBaseController;
import com.borodich.entity.Section;
import com.borodich.service.api.SectionService;

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
public class SectionController extends AbstractBaseController{
    
    @Autowired
    private SectionService sectionService;

    @GetMapping("section/{id}")
    public @ResponseBody Map<String, Object> getEntityById(@PathVariable(ID) Integer id) {
	Section section = sectionService.getById(id);
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", section);
	return result;
    }

    @GetMapping("sections/")
    public @ResponseBody Map<String, Object> getEntities() {
	List<Section> sections = sectionService.getAll();
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", sections);
	return result;
    }

    @PostMapping("section/")
    public @ResponseBody Map<String, Object> createEntity(@RequestBody Section entity) {
	Map<String, Object> result = new HashMap<String, Object>();
	sectionService.create(entity);
	result.put("result", "created");
	return result;
    }

    @DeleteMapping("section/")
    public @ResponseBody Map<String, Object> deleteEntity(@RequestBody Section entity) {
	Map<String, Object> result = new HashMap<String, Object>();
	sectionService.delete(entity);
	result.put("result", "deleted");
	return result;
    }

    @PutMapping("section/")
    public @ResponseBody Map<String, Object> updateEntity(@RequestBody Section entity) {
	Map<String, Object> result = new HashMap<String, Object>();
	sectionService.update(entity);
	result.put("result", entity);
	return result;
    }
}