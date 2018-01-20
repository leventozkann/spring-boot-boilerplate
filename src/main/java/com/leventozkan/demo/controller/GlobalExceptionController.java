package com.leventozkan.demo.controller;

import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.leventozkan.demo.exception.ResourceNotFoundException;

@ControllerAdvice
public class GlobalExceptionController {

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleAccessDeniedException(ResourceNotFoundException ex, HttpServletRequest request, Locale locale) {
		String errorMessage = messageSource.getMessage("exception.resourcenotfound", new Object[] {}, locale);
		return new ResponseEntity<Object>(errorMessage +" "+ ex.getResourceName(), new HttpHeaders(), HttpStatus.NOT_FOUND);
	}


	@ExceptionHandler(FileNotFoundException.class)
	public ResponseEntity<Object> handleFileNotFoundException(FileNotFoundException ex, HttpServletRequest request, Locale locale) {
		String errorMessage = messageSource.getMessage("exception.filenotfound", new Object[] {}, locale);
		return new ResponseEntity<Object>(errorMessage, new HttpHeaders(), HttpStatus.OK);
	}
	
	@ExceptionHandler({InterruptedException.class,ExecutionException.class})
	public ResponseEntity<Object> handleException(Exception ex, HttpServletRequest request, Locale locale) {
		String errorMessage = messageSource.getMessage("exception.generalexception", new Object[] {}, locale);
		return new ResponseEntity<Object>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
