package com.brunini.dsmc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brunini.dsmc.model.entities.Category;
import com.brunini.dsmc.model.entities.City;
import com.brunini.dsmc.model.entities.Product;
import com.brunini.dsmc.model.entities.State;
import com.brunini.dsmc.repositories.CategoryRepository;
import com.brunini.dsmc.repositories.CityRepository;
import com.brunini.dsmc.repositories.ProductRepository;
import com.brunini.dsmc.repositories.StateRepository;

@SpringBootApplication
public class DsMcApplication implements CommandLineRunner {
	@Autowired
	private CategoryRepository catRepo;
	@Autowired
	private ProductRepository prodRepo;
	@Autowired
	private StateRepository stateRepo;
	@Autowired
	private CityRepository cityRepo;
	

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
		
				
		State state1 = new State(null, "Paraíba");
		State state2 = new State(null, "São Paulo");
		
		City city1 = new City(null, "Campina Grande", state1);
		City city2 = new City(null, "São Paulo", state2);
		City city3 = new City(null, "Alagoa Nova", state1);
		
		state1.getCities().add(city3);
		state1.getCities().add(city1);
		
		state2.getCities().add(city2);
		
		stateRepo.saveAll(Arrays.asList(state1, state2));
		cityRepo.saveAll(Arrays.asList(city1,city2,city3));
	}

	/*
	 * INSERT INTO CATEGORY (NAME) VALUES ('OFFICE'); 
	 * INSERT INTO CATEGORY (NAME) VALUES ('GAMES');
	 */

}
