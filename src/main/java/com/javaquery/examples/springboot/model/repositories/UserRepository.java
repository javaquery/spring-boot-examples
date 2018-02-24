package com.javaquery.examples.springboot.model.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaquery.examples.springboot.model.User;

/**
 * @author javaQuery
 * @since 2018-02-18
 */
public interface UserRepository extends JpaRepository<User, UUID>{
}
