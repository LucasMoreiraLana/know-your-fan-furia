package com.example.know_your_fan.controller;

import com.example.know_your_fan.entity.User;
import com.example.know_your_fan.service.GetUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/users")
public class GetUserController {

    @Autowired
    private GetUserService getUserService;

    @GetMapping
    public List<GetUserResponse> getUsers() {
        return getUserService.getAllUsers()
                .stream()
                .map(user -> new GetUserResponse(
                        user.getId(),
                        user.getEmail(),
                        user.getName(),
                        user.getSocial(),
                        user.getDescription()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetUserResponse> getUserById(@PathVariable String id) {
        return getUserService.getUserById(id)
                .map(user -> new GetUserResponse(
                        user.getId(),
                        user.getEmail(),
                        user.getName(),
                        user.getSocial(),
                        user.getDescription()))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}
