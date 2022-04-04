package com.brunini.dsmc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunini.dsmc.model.entities.Product;
import com.brunini.dsmc.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public Product findById(Integer id) {
		Product obj = repository.findById(id).get();
		return obj;
	}
}
