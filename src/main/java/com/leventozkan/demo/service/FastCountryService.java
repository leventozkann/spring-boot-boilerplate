package com.leventozkan.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leventozkan.demo.domain.Country;
import com.leventozkan.demo.repository.CountryRepository;

@Service
public class FastCountryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FastCountryService.class);	
	
	@Autowired
	CountryRepository countryRepository;

 
	/* Multithread Result Set Example */
	public List<Country> getSomeCountries(){
		
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		final ResultSet reSet = new ResultSet();
		Runnable country1;
		Runnable country2;
		Runnable country3;
		
		
		country1 = new Runnable() {
			@Override
			public void run() {
				LOGGER.info("getting country1");
				reSet.country1 = null;countryRepository.findByNameAllIgnoringCase("Mexico");
			}
		};
		executorService.execute(country1);
		
		country2 = new Runnable() {
			@Override
			public void run() {
				LOGGER.info("getting country2");
				reSet.country2 = countryRepository.findByNameAllIgnoringCase("turkey");
			}
		};
		executorService.execute(country2);
		
		
		country3 = new Runnable() {
			@Override
			public void run() {
				LOGGER.info("getting country3");
				reSet.country3 = countryRepository.findByNameAllIgnoringCase("china");
			}
		};
		
		executorService.execute(country3);
		
		
        executorService.shutdown();
        
        try {
               executorService.awaitTermination(Long.MAX_VALUE,TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
        		LOGGER.error("Exception has occured: ",e);
        }
		
		List<Country> countryList =  new ArrayList<>();
		countryList.add(reSet.country1);
		countryList.add(reSet.country2);
		countryList.add(reSet.country3);
		
		// you may add some business code here according to your business context.
		return countryList;
	}
	
	private class ResultSet{
        Country country1 = null;
        Country country2 = null;
        Country country3 = null;
    }
	
	
	
	/* Multithread Feature  Example */
	public List<Country> getAnotherSomeCountries(){
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		   Future<Country> task1Future = executorService.submit(new Callable<Country>() {
			   
		        public Country call() throws Exception {        
		            System.out.println(String.format("starting expensive task thread %s", Thread.currentThread().getName()));
		            Country returnedValue = countryRepository.findByNameAllIgnoringCase("Brazil");    
		   
		            return returnedValue;
		        }           
		    });
		   
		   Future<Country> task2Future = executorService.submit(new Callable<Country>() {
			   
		        public Country call() throws Exception {        
		            System.out.println(String.format("starting expensive task thread %s", Thread.currentThread().getName()));
		            Country returnedValue = countryRepository.findByNameAllIgnoringCase("Russia");    
		   
		            return returnedValue;
		        }           
		    });
		   
		   Future<Country> task3Future = executorService.submit(new Callable<Country>() {
			   
		        public Country call() throws Exception {        
		            System.out.println(String.format("starting expensive task thread %s", Thread.currentThread().getName()));
		            Country returnedValue = countryRepository.findByNameAllIgnoringCase("Nigeria");    
		   
		            return returnedValue;
		        }           
		    });
		   
		  
		
		List<Country> countryList =  new ArrayList<>();
		
		Country country1= null;
		try {
			country1 = task1Future.get();
		} catch (InterruptedException | ExecutionException e) {
			LOGGER.error("error at getting country1");
		}
		Country country2 = null;
		try {
			country2 = task2Future.get();
		} catch (InterruptedException | ExecutionException e) {
			LOGGER.error("error at getting country2");
		}
		Country country3 = null;
		try {
			country3 = task3Future.get();
		} catch (InterruptedException | ExecutionException e) {
			LOGGER.error("error at getting country2");
		}
		
		countryList.add(country1);
		countryList.add(country2);
		countryList.add(country3);
		
		return countryList;
	}
		
}
