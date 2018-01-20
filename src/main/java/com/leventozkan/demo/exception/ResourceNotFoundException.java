package com.leventozkan.demo.exception;

public class ResourceNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7000158415125611519L;
	private String resourceName;

	public ResourceNotFoundException() {
	}
	
	public ResourceNotFoundException(String resourceName) {
		this.setResourceName(resourceName);
	}

	public ResourceNotFoundException(String resourceName, String message) {
		super(message);
		this.setResourceName(resourceName);
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
}
