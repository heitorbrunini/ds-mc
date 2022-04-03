package com.brunini.dsmc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunini.dsmc.model.entities.Category;
import com.brunini.dsmc.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping (value = "/{id}")
	public ResponseEntity<?> findAll(@PathVariable Integer id) {
		
		Category obj  = service.findById(id);			
		return ResponseEntity.ok().body(obj);
		
	}
}
