package com.brunini.dsmc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunini.dsmc.model.entities.Category;
import com.brunini.dsmc.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public Category findById(Integer id) {
		Category obj = repository.findById(id).get();
		return obj;
	}
}
