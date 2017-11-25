package com.leventozkan.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.leventozkan.demo.constants.AppConstants;
import com.leventozkan.demo.domain.Country;
import com.leventozkan.demo.repository.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	CountryRepository countryRepository;

	@Cacheable(cacheNames= AppConstants.CACHE_NAME_COUNTRY_LIST)
	public List<Country> getAllCountries(){
		
		List<Country> countryList = countryRepository.findAll();		
		
		// you may add some business code here according to your business context.
		return countryList;
	}
	
	
	public Country readCountry(String countryName){
		
		Country country= countryRepository.findByNameAllIgnoringCase(countryName);
		
		// you may add some business code here according to your business context.
		return country;
	}
}
