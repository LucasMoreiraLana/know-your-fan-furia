package com.example.know_your_fan.controller;

import com.example.know_your_fan.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/login")
public class PostLoginController {

    @Autowired
    private LoginUserService loginUserService;

    @PostMapping
    public ResponseEntity<PostLoginResponse> login(@RequestBody PostLoginRequest postLoginRequest){
        if(postLoginRequest.email() == null || postLoginRequest.password() == null){
            return ResponseEntity.status(400).body(new PostLoginResponse(
                    400, "Email e senha são obrigatórios!"));

        }

        boolean isValid = loginUserService.login(postLoginRequest);

        if(isValid){
            return ResponseEntity.status(200).body(new PostLoginResponse(
                    200, "Login bem sucedido!"
            ));
        }else{
            return ResponseEntity.status(404).body(new PostLoginResponse(
                    404, "Usuário não encontrado ou credenciais incorretas!"));
        }
    }

}
