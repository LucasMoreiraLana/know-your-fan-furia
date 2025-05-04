package com.example.know_your_fan.service;

import com.example.know_your_fan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserService {

    @Autowired
    private UserRepository userRepository;

    public void deleteUser(String id){
        if(!userRepository.existsById(id)){
            throw new RuntimeException("Usuário não encontrado com o id: " + id);
        }

        userRepository.deleteById(id);
    }

}
