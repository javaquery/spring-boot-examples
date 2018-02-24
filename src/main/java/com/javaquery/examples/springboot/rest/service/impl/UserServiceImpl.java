package com.javaquery.examples.springboot.rest.service.impl;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaquery.examples.springboot.model.User;
import com.javaquery.examples.springboot.model.repositories.UserRepository;
import com.javaquery.examples.springboot.rest.dto.UserDTO;
import com.javaquery.examples.springboot.rest.dto.UserUpdateDTO;
import com.javaquery.examples.springboot.rest.exception.EntityNotFoundException;
import com.javaquery.examples.springboot.rest.service.UserService;

/**
 * @author javaQuery
 * @since 2018-02-18
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDTO addUser(UserDTO userDTO) {
		Date now = new Date();
		
		/**
		 * We are manually creating {@link User} object however there is mapper available  to convert to-from {@link UserDTO}.
		 */
		User user = new User();
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setCreated(now);
		user.setModified(now);
		userRepository.save(user);
		
		/* set generated user id to response object */
		userDTO.setId(user.getId());
		userDTO.setPassword("");
		return userDTO;
	}

	@Override
	public UserDTO getUser(UUID id) {
		User user = userRepository.getOne(id);
		if(Objects.isNull(user)){
			/* handle this exception using {@link RestExceptionHandler} */
			throw new EntityNotFoundException(User.class, id);
		}
		return new UserDTO().build(user);
	}

	@Override
	public UserDTO updateUser(UserUpdateDTO userUpdateDTO, UUID id) {
		User user = userRepository.getOne(id);
		if(Objects.isNull(user)){
			/* handle this exception using {@link RestExceptionHandler} */
			throw new EntityNotFoundException(User.class, id);
		}
		user.setFirstName(userUpdateDTO.getFirstName());
		user.setLastName(userUpdateDTO.getLastName());
		userRepository.save(user);
		return new UserDTO().build(user);
	}

	@Override
	public void deleteUser(UUID id) {
		userRepository.delete(id);
	}
}
