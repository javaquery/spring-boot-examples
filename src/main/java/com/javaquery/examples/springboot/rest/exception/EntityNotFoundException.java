package com.javaquery.examples.springboot.rest.exception;

/**
 * @author vicky.thakor
 * @since 2018-02-18
 */
public class EntityNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(Class<?> entityClass, Object id) {
		super(String.format("%s was not found for parameter %s", entityClass.getSimpleName(), id));
	}
}
