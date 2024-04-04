package com.Bankingapp.Bankingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.Bankingapp.Bankingapp.entity.UserModel;
import com.Bankingapp.Bankingapp.service.UserService;

@RestController
// @RequestMapping("api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> SignUp(@RequestBody UserModel user) {
        return userService.signUp(user);
        
    }

    @PostMapping("/login/{userName}")
    public boolean auth(@PathVariable("userName") String userName,@RequestHeader String password) {      
       return userService.authenticate(userName,password);
    }
    

    
}