package com.Bankingapp.Bankingapp.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Bankingapp.Bankingapp.entity.User;
import com.Bankingapp.Bankingapp.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private  UserRepository userRepository;

   

    public ResponseEntity<String> save(User user) {
        try {
            User existingUser = userRepository.findByUsername(user.getUsername());
            if (existingUser == null) {
                // You might want to hash the password before saving it to the database
                // user.setPassword(passwordEncoder.encode(user.getPassword()));
                userRepository.save(user);
                return ResponseEntity.status(HttpStatus.OK).body("Signup Successful");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while signing up");
        }
    }
}
		
	



