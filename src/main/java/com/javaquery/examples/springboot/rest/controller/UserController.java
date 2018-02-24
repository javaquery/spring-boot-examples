package com.javaquery.examples.springboot.rest.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaquery.examples.springboot.rest.dto.UserDTO;
import com.javaquery.examples.springboot.rest.dto.UserUpdateDTO;
import com.javaquery.examples.springboot.rest.response.SuccessResponse;
import com.javaquery.examples.springboot.rest.service.UserService;

/**
 * @author javaQuery
 * @since 2018-02-18
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService; 
	
	@PostMapping
	public ResponseEntity<UserDTO> addUser(@Valid @RequestBody UserDTO userDTO){
		return ResponseEntity.ok(userService.addUser(userDTO));
	}
	
	@GetMapping
	public ResponseEntity<UserDTO> getUser(@RequestParam UUID id){
		return ResponseEntity.ok(userService.getUser(id));
	}
	
	@PutMapping
	public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserUpdateDTO userUpdateDTO, @RequestParam UUID id){
		return ResponseEntity.ok(userService.updateUser(userUpdateDTO, id));
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteUser(@RequestParam UUID id){
		userService.deleteUser(id);
		return ResponseEntity.ok(new SuccessResponse("deleted"));
	}
}
