package com.wesleymartins.codigocerto.controllers;

import com.wesleymartins.codigocerto.entities.User;
import com.wesleymartins.codigocerto.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> insert(User user){
        return ResponseEntity.ok().body(user);
    }
}
