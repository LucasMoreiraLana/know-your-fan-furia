package com.example.know_your_fan.service;

import com.example.know_your_fan.controller.PostLoginRequest;
import com.example.know_your_fan.entity.User;
import com.example.know_your_fan.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginUserService {

    @Autowired
    private UserRepository userRepository;


   public boolean login(PostLoginRequest postLoginRequest){
       User user = userRepository.findByEmail(postLoginRequest.email())
               .orElse(null);

       if (user == null) {
           return false;
       }
       return user.getPassword().equals(postLoginRequest.password());
   }
}
