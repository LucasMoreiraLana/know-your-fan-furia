package com.example.know_your_fan.controller;

import com.example.know_your_fan.service.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/create")
public class PostCreateUserController {

    @Autowired
    private CreateUserService createUserService;

    @PostMapping
    public void createUser(@RequestBody PostCreateUserRequest postCreateUserRequest){

        createUserService.createUser(postCreateUserRequest);
    }

}
