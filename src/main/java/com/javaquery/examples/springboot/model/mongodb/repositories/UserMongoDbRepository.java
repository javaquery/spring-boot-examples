package com.javaquery.examples.springboot.model.mongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.javaquery.examples.springboot.model.mongodb.User;

/**
 * @author javaQuery
 * @since 2018-09-24
 * @github https://github.com/javaquery/spring-boot-examples
 */
public interface UserMongoDbRepository extends MongoRepository<User, String>{
}
