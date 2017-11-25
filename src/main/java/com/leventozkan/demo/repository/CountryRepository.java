package com.leventozkan.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leventozkan.demo.domain.Country;

public interface CountryRepository extends JpaRepository<Country,Long>  {

	List<Country> findAll();
	
	Country findByNameAllIgnoringCase(String name);
}
