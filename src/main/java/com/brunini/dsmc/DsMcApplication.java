package com.brunini.dsmc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brunini.dsmc.model.entities.Category;
import com.brunini.dsmc.model.entities.Product;
import com.brunini.dsmc.repositories.CategoryRepository;
import com.brunini.dsmc.repositories.ProductRepository;

@SpringBootApplication
public class DsMcApplication implements CommandLineRunner {
	@Autowired
	private CategoryRepository catRepo;
	@Autowired
	private ProductRepository prodRepo;

	public static void main(String[] args) {
		SpringApplication.run(DsMcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Games");
		Category cat2 = new Category(null, "Office");
		
		
		Product prod1 = new Product(null, 10.00, "Optical Mouse");
		Product prod2 = new Product(null, 5.00, "Bic Pincel");
		Product prod3 = new Product(null, 1000.00, "Computer");
		
		cat1.getProducts().addAll(Arrays.asList(prod1,prod3));
		cat2.getProducts().addAll(Arrays.asList(prod1,prod2,prod3));
		
		prod1.getCategories().addAll(Arrays.asList(cat1,cat2));
		prod2.getCategories().add(cat2);
		prod3.getCategories().addAll(Arrays.asList(cat1,cat2));
		catRepo.saveAll(Arrays.asList(cat1,cat2));
		
		prodRepo.saveAll(Arrays.asList(prod1,prod2,prod3));
		
		
	}

	/*
	 * INSERT INTO CATEGORY (NAME) VALUES ('OFFICE'); 
	 * INSERT INTO CATEGORY (NAME) VALUES ('GAMES');
	 */

}
