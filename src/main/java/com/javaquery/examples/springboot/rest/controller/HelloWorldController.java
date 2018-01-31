package com.javaquery.examples.springboot.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author javaQuery
 * @since 2018-01-31
 * @github https://github.com/javaquery/spring-boot-examples
 */
@RestController
@RequestMapping("/api") 
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
}
