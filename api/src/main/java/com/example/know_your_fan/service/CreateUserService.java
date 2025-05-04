package com.example.know_your_fan.service;

import com.example.know_your_fan.controller.PostCreateUserRequest;
import com.example.know_your_fan.entity.User;
import com.example.know_your_fan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateUserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(PostCreateUserRequest postCreateUserRequest){
        var entity = new User(
                UUID.randomUUID().toString(),
                postCreateUserRequest.email(),
                postCreateUserRequest.password(),
                postCreateUserRequest.name(),
                postCreateUserRequest.social(),
                postCreateUserRequest.description()
        );

        userRepository.save(entity);
    }

}
