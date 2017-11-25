package com.leventozkan.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.leventozkan.demo.domain.Country;
import com.leventozkan.demo.repository.CountryRepository;

/**
 * Spring Boot provides ApplicationRunner class to run specific piece of code when application is fully started. 
 * This interface get called just before run() on SpringApplication completes.
 * */

@Component
public class DataLoaderService  implements ApplicationRunner {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DataLoaderService.class);	

	@Autowired
	CountryRepository countryRepostiory;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
	
		
		LOGGER.info("initial data load started");
		
		Country c1 = new Country("Turkey", 80745020);
		countryRepostiory.save(c1);
		
		Country c2 = new Country("China", 1409517397);
		countryRepostiory.save(c2);
		
		Country c3 = new Country("India", 1339180127);
		countryRepostiory.save(c3);
		
		Country c4 = new Country("U.S.", 324459463);
		countryRepostiory.save(c4);
		
		Country c5 = new Country("Indonesia",263991379);
		countryRepostiory.save(c5);
		
		Country c6 = new Country("Brazil", 209288278);
		countryRepostiory.save(c6);
		
		Country c7 = new Country("Pakistan",197015955);
		countryRepostiory.save(c7);
		
		Country c8 = new Country("Nigeria", 190886311);
		countryRepostiory.save(c8);
		
		Country c9 = new Country("Bangladesh",164669751);
		countryRepostiory.save(c9);
		
		Country c10 = new Country("Russia", 143989754);
		countryRepostiory.save(c10);
		
		Country c11 = new Country("Mexico", 129163276);
		countryRepostiory.save(c11);
		
		Country c12 = new Country("Japan", 127484450);
		countryRepostiory.save(c12);

		
		LOGGER.info("initial data load has finished");
		
		
		
	}

}
