package com.example.know_your_fan.service;


import com.example.know_your_fan.entity.User;
import com.example.know_your_fan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class GetUserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){

        return userRepository.findAll();
    }

    public Optional<User> getUserById(String id){
        return userRepository.findById(id);
    }

}
