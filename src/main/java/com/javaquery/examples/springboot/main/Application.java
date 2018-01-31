package com.javaquery.examples.springboot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author javaQuery
 * @since 2018-01-31
 * @github https://github.com/javaquery/spring-boot-examples
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.javaquery.examples.springboot.rest" })
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}