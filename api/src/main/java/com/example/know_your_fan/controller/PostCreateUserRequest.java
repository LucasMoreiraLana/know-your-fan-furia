package com.example.know_your_fan.controller;


public record PostCreateUserRequest(String email, String password, String name, String social, String description) {}
