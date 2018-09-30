package com.javaquery.examples.springboot.rest.service;

import com.javaquery.examples.springboot.rest.dto.UserMongoDbDTO;
import com.javaquery.examples.springboot.rest.dto.UserUpdateDTO;

/**
 * @author javaQuery
 * @since 2018-09-24
 * @github https://github.com/javaquery/spring-boot-examples
 */
public interface UserMongoDbService {
    public UserMongoDbDTO addUser(UserMongoDbDTO userDTO);
    public UserMongoDbDTO getUser(String id);
    public UserMongoDbDTO updateUser(UserUpdateDTO userUpdateDTO, String id);
    public void deleteUser(String id);
}
