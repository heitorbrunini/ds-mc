package com.brunini.dsmc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunini.dsmc.model.entities.Category;
import com.brunini.dsmc.repositories.CategoryRepository;
import com.brunini.dsmc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public Category findById(Integer id) {
		Optional<Category> obj = repository.findById(id);
		return obj.orElseThrow(
			() -> new ObjectNotFoundException("Object not found! id: " +id+ " type: " + Category.class.getName())	
		);
	}
}
