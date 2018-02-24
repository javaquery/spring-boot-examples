package com.javaquery.examples.springboot.model;

import java.util.Date;

/**
 * @author vicky.thakor
 * @since 2017-09-30
 * @see http://javainterfaces.com/modifiableentity.php
 */
public interface ModifiableEntity {
	public Date getModified();
    public void setModified(Date modified);
}
