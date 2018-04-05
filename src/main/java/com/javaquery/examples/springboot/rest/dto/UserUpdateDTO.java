package com.javaquery.examples.springboot.rest.dto;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Object to interact using rest api.
 * @author javaQuery
 * @since 2018-02-18
 */
public class UserUpdateDTO {
	@NotEmpty(message = "first_name can not be empty")
	@JsonProperty("first_name")
	private String firstName;
	
	@NotEmpty(message = "last_name can not be empty")
	@JsonProperty("last_name")
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
