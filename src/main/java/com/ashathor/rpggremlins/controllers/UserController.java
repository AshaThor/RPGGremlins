package com.ashathor.rpggremlins.controllers;

import com.ashathor.rpggremlins.models.User;
import com.ashathor.rpggremlins.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


public class UserController {

    @Autowired
    private UserRepository userRepository;

    public User get(@PathVariable("user") String name ){
        return userRepository.findByUsername(name);
    }

}
