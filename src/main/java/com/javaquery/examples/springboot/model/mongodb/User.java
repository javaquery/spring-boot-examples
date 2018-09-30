package com.javaquery.examples.springboot.model.mongodb;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author javaQuery
 * @since 2018-09-24
 * @github https://github.com/javaquery/spring-boot-examples
 */
@Document(collection = "users")
public class User {

	@Id
	public String id;

	@Field("first_name")
	@NotEmpty(message = "first_name can not be empty.")
	@Size(max = 100, message = "first_name can not be more than 100 characters.")
	private String firstName;

	@Field("last_name")
	@NotEmpty(message = "last_name can not be empty.")
	@Size(max = 100, message = "last_name can not be more than 100 characters.")
	private String lastName;

	@Field("email")
	@NotEmpty(message = "email can not be empty.")
	@Size(max = 100, message = "email can not be more than 100 characters.")
	private String email;

	@Field("password")
	@NotEmpty(message = "password can not be empty.")
	@Size(max = 100, message = "password can not be more than 100 characters.")
	private String password;

	@Field("created")
	private Long created = (new Date().getTime()) / 1000;

	@Field("modified")
	private Long modified = (new Date().getTime()) / 1000;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getCreated() {
		return created;
	}

	public void setCreated(Long created) {
		this.created = created;
	}

	public Long getModified() {
		return modified;
	}

	public void setModified(Long modified) {
		this.modified = modified;
	}
}
