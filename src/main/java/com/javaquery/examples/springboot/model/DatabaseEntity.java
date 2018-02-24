package com.javaquery.examples.springboot.model;

import java.util.UUID;

/**
 * @author vicky.thakor
 * @since 2017-09-30
 * @see http://javainterfaces.com/databaseentity.php
 */
public interface DatabaseEntity {
	public UUID getId();
	public void setId(UUID id);
}
