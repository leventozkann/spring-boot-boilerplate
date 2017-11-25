package com.leventozkan.demo.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.leventozkan.demo.constants.AppConstants;

@Component
public class CacheCleanerTask {

	private static final Logger LOGGER = LoggerFactory.getLogger(CacheCleanerTask.class);

	@CacheEvict(cacheNames = AppConstants.CACHE_NAME_COUNTRY_LIST,allEntries=true)
	@Scheduled(cron = AppConstants.CRON_EVERYDAY_AT_MIDNIGHT)
	public void cleanCountryListCache(){
		LOGGER.info(AppConstants.CACHE_NAME_COUNTRY_LIST +" cache has removed from cache successfully...");
	}

}
