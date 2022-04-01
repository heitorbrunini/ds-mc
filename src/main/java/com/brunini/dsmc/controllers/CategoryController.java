package com.brunini.dsmc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunini.dsmc.model.entities.Category;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
	
	@GetMapping
	public List<Category> findAll() {
		
		Category cat1 = new Category(1, "Games");
		Category cat2 = new Category(2,"Office");
		Category cat3 = new Category(3,"Classroom");
		
		List<Category> list = new ArrayList<>();
		list.add(cat1);
		list.add(cat2);
		list.add(cat3);
			
		return list;
	}
}
