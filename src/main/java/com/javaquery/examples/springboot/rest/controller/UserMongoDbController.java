package com.javaquery.examples.springboot.rest.controller;

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
import com.javaquery.examples.springboot.rest.dto.UserMongoDbDTO;
import com.javaquery.examples.springboot.rest.dto.UserUpdateDTO;
import com.javaquery.examples.springboot.rest.response.SuccessResponse;
import com.javaquery.examples.springboot.rest.service.UserMongoDbService;

/**
 * @author javaQuery
 * @since 2018-09-24
 * @github https://github.com/javaquery/spring-boot-examples
 */
@RestController
@RequestMapping("/api/user/mongodb")
public class UserMongoDbController {

    @Autowired
    private UserMongoDbService userMongoDbService;

    @PostMapping
    public ResponseEntity<UserMongoDbDTO> addUser(@Valid @RequestBody UserMongoDbDTO userDTO) {
        return ResponseEntity.ok(userMongoDbService.addUser(userDTO));
    }

    @GetMapping
    public ResponseEntity<UserMongoDbDTO> getUser(@RequestParam String id) {
        return ResponseEntity.ok(userMongoDbService.getUser(id));
    }

    @PutMapping
    public ResponseEntity<UserMongoDbDTO> updateUser(@Valid @RequestBody UserUpdateDTO userUpdateDTO, @RequestParam String id) {
        return ResponseEntity.ok(userMongoDbService.updateUser(userUpdateDTO, id));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser(@RequestParam String id) {
        userMongoDbService.deleteUser(id);
        return ResponseEntity.ok(new SuccessResponse("deleted"));
    }
}
