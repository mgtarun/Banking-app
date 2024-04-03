package com.Bankingapp.Bankingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Bankingapp.Bankingapp.entity.User;
import com.Bankingapp.Bankingapp.repository.UserRepository;
import com.Bankingapp.Bankingapp.service.UserService;

@RestController
	public class UserController {
        @Autowired
	    private  UserService userService;

		private UserRepository userRepository;

	    @PostMapping("/user")
	    public ResponseEntity<String> loginUser(@RequestBody User loginUser) {
	        // Check if the user exists in the database
	        User user = userRepository.findByUsername(loginUser.getUsername());
	        if (user == null) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
	        }

	        // Check if the password matches
	        if (!user.getPassword().equals(loginUser.getPassword())) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
	        }

	        return ResponseEntity.ok("Login successful");
			
	    }
		@PostMapping("/signup")
    public ResponseEntity<String> SignUp(@RequestBody User user) {
        return userService.save(user);
        
    }
	}



