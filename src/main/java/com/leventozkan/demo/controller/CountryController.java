package com.leventozkan.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leventozkan.demo.constants.AppConstants;
import com.leventozkan.demo.domain.Country;
import com.leventozkan.demo.service.CountryService;

@RestController
public class CountryController {

	@Autowired
	CountryService countryService;
	
	@RequestMapping(value = AppConstants.URL_MAP_COUNTRY_LIST, method = RequestMethod.GET)
	public ResponseEntity<List<Country>> getAllCountries() {
		
		List<Country> countryList =  countryService.getAllCountries();
	
		return new ResponseEntity<List<Country>>(countryList, HttpStatus.OK);
	}
	
	@RequestMapping(value = AppConstants.URL_MAP_COUNTRY_READ +"/{countryName}", method = RequestMethod.GET)
	public ResponseEntity<Country> getCountryByName(@PathVariable String countryName) {
		
		Country country =  countryService.readCountry(countryName);
		
		return new ResponseEntity<Country>(country, HttpStatus.OK);
	}
	
}
