package com.brunini.dsmc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brunini.dsmc.model.entities.City;

@Repository
public interface CityRepository extends JpaRepository <City, Integer>{
	
}
