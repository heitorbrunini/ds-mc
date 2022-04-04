package com.brunini.dsmc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunini.dsmc.model.entities.Category;
import com.brunini.dsmc.model.entities.Product;
import com.brunini.dsmc.repositories.ProductRepository;
import com.brunini.dsmc.services.exceptions.ObjectNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public Product findById(Integer id) {
		Optional<Product> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! id: " + id + " type: " + Category.class.getName())
		);
	}
}
