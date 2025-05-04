package com.example.know_your_fan.controller;

import com.example.know_your_fan.entity.User;
import com.example.know_your_fan.service.UpdateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/update")
public class UpdateUserController {

    @Autowired
    UpdateUserService updateUserService;

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody UpdateUserRequest updateUserRequest){

        User updateUser = updateUserService.updateUser(id, updateUserRequest);
        return ResponseEntity.ok(updateUser);

    }
}
