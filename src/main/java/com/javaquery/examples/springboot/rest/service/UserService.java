package com.javaquery.examples.springboot.rest.service;

import java.util.UUID;

import com.javaquery.examples.springboot.rest.dto.UserDTO;
import com.javaquery.examples.springboot.rest.dto.UserUpdateDTO;

/**
 * @author javaQuery
 * @since 2018-02-18
 * @github https://github.com/javaquery/spring-boot-examples
 */
public interface UserService {
	public UserDTO addUser(UserDTO userDTO);
	public UserDTO getUser(UUID id);
	public UserDTO updateUser(UserUpdateDTO userUpdateDTO, UUID id);
	public void deleteUser(UUID id);
}
