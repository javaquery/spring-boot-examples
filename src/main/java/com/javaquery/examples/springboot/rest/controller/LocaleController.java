package com.javaquery.examples.springboot.rest.controller;

import java.util.Locale;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Springboot internationalization example
 * @author javaQuery
 * @since 2018-04-06  
 */
@RestController
@RequestMapping("/api")
@Validated
public class LocaleController {
	
	@Autowired
	private MessageSource messageSource; 
	
	/**
	 * Response internationalization.
	 * @param name
	 * @param locale
	 * @return
	 */
	@GetMapping("/locale")
	public ResponseEntity<?> sayHello(@RequestParam("name") String name, Locale locale){
		String localeHello = messageSource.getMessage("springboot.hello", null, locale);
		return ResponseEntity.ok(localeHello + " " + name);
	}
	
	/**
	 * Validation parameter internationalization. 
	 * @param firstname
	 * @param lastname
	 * @param locale
	 * @return
	 */
	@GetMapping("/locale/param")
	public ResponseEntity<?> parameterValidation(@Size(min = 1, max = 5, message = "firstname {javax.validation.constraints.Size.message}") @RequestParam("firstname") String firstname,
			@NotEmpty(message = "lastname {org.hibernate.validator.constraints.NotEmpty.message}") @RequestParam("lastname") String lastname,
			Locale locale){
		String localeHello = messageSource.getMessage("springboot.hello", null, locale);
		return ResponseEntity.ok(localeHello + " " + firstname + " " + lastname);
	}
}
