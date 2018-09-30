package com.javaquery.examples.springboot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author javaQuery
 * @since 2018-01-31
 * @github https://github.com/javaquery/spring-boot-examples
 * 
 * @change message internationalization (locale)
 * 
 * @change mongodb integration
 * @since 2018-09-24
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.javaquery.examples.springboot.rest",  "com.javaquery.examples.springboot.main.config"})
@EntityScan("com.javaquery.examples.springboot.model")
@EnableJpaRepositories("com.javaquery.examples.springboot.model.repositories")
@EnableMongoRepositories("com.javaquery.examples.springboot.model.mongodb.repositories")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}