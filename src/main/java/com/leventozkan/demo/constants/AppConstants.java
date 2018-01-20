package com.leventozkan.demo.constants;

public class AppConstants {
	
	/*URL MAPPING CONSTANTS*/
	public static final String URL_MAP_COUNTRY_LIST= "/list/countries";
	public static final String URL_MAP_COUNTRY_READ= "/read/country";
	
	
	/*PARAMETER CONSTANTS*/
	public static final String PARAMETER_LANG= "lang";
	
	
	/*CACHE NAME CONSTANTS*/
	public static final String CACHE_NAME_COUNTRY_LIST= "country-list";
	
	
	/*CRON SCHEDULERS*/
	public static final String CRON_EVERY_TWO_MINUTES = "0 0/2 * 1/1 * ?";
	public static final String CRON_EVERY_TWO_HOURS = "0 0 0/2 * * ?";
	public static final String CRON_EVERY_HOUR = "0 0 0/1 * * ?";
	public static final String CRON_EVERYDAY_AT_FIVE_AM = "0 0 5 * * ?";
	public static final String CRON_EVERYDAY_AT_MIDNIGHT = "0 0 0 * * ?";

}
