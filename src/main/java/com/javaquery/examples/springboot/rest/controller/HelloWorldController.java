package com.javaquery.examples.springboot.rest.controller;

import javax.validation.constraints.Size;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author javaQuery
 * @since 2018-01-31
 * @github https://github.com/javaquery/spring-boot-examples
 */
@RestController
@RequestMapping("/api")
@Validated
public class HelloWorldController {
	
	/**
	 * This will send Hello World in response with HTTP status code 200.
	 * @return
	 */
	@GetMapping("/helloworld")
	public ResponseEntity<?> sayHello(){
		/* return response */
		return ResponseEntity.ok("Hello World");
	}
	
	/**
	 * This will send Hello {name-from-parameter} in response with HTTP status code 200.
	 * @since 2018-02-01
	 * @param firstname
	 * @param lastname
	 * @return
	 */
	@GetMapping("/hello")
	public ResponseEntity<?> sayHello(
			@RequestParam @Size(min= 1, max = 100 , message = "firstname length must be between 1 and 100") String firstname,
			@RequestParam(required = false) String lastname){
		/* check lastname value */
		lastname = lastname != null ? lastname : "{lastname-not-found}";
		return ResponseEntity.ok("Hello " + firstname + " " + lastname);
	}
}
