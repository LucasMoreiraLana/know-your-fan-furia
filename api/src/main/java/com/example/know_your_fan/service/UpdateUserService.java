package com.example.know_your_fan.service;

import com.example.know_your_fan.controller.UpdateUserRequest;
import com.example.know_your_fan.entity.User;
import com.example.know_your_fan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateUserService {

    @Autowired
    UserRepository userRepository;

    public User updateUser(String id, UpdateUserRequest updateUserRequest){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if(updateUserRequest.password() != null && !updateUserRequest.password().isEmpty()){
            user.setPassword(updateUserRequest.password());
        }

        if(updateUserRequest.social() != null && !updateUserRequest.social().isEmpty()){
            user.setSocial(updateUserRequest.social());
        }

        return userRepository.save(user);

    }
}
