package com.javaquery.examples.springboot.rest.service.impl;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javaquery.examples.springboot.model.mongodb.User;
import com.javaquery.examples.springboot.model.mongodb.repositories.UserMongoDbRepository;
import com.javaquery.examples.springboot.rest.dto.UserMongoDbDTO;
import com.javaquery.examples.springboot.rest.dto.UserUpdateDTO;
import com.javaquery.examples.springboot.rest.exception.EntityNotFoundException;
import com.javaquery.examples.springboot.rest.service.UserMongoDbService;

/**
 * @author javaQuery
 * @since 2018-09-24
 * @github https://github.com/javaquery/spring-boot-examples
 */
@Service
public class UserMongoDbServiceImpl implements UserMongoDbService {

    @Autowired
    private UserMongoDbRepository userMongoDbRepository;

    @Override
    public UserMongoDbDTO addUser(UserMongoDbDTO userDTO) {
        /**
         * We are manually creating {@link User} object however there is mapper
         * available to convert to-from {@link UserDTO}.
         */
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        userMongoDbRepository.save(user);

        /* set generated user id to response object */
        userDTO.setId(user.getId());
        userDTO.setPassword("");
        return userDTO;
    }

    @Override
    public UserMongoDbDTO getUser(String id) {
        User user = userMongoDbRepository.findOne(id);
        if (Objects.isNull(user)) {
            /* handle this exception using {@link RestExceptionHandler} */
            throw new EntityNotFoundException(User.class, id);
        }
        return new UserMongoDbDTO().build(user);
    }

    @Override
    public UserMongoDbDTO updateUser(UserUpdateDTO userUpdateDTO, String id) {
        User user = userMongoDbRepository.findOne(id);
        if (Objects.isNull(user)) {
            /* handle this exception using {@link RestExceptionHandler} */
            throw new EntityNotFoundException(User.class, id);
        }
        user.setFirstName(userUpdateDTO.getFirstName());
        user.setLastName(userUpdateDTO.getLastName());
        userMongoDbRepository.save(user);
        return new UserMongoDbDTO().build(user);
    }

    @Override
    public void deleteUser(String id) {
        userMongoDbRepository.delete(id);
    }
}
