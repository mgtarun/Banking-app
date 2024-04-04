package com.Bankingapp.Bankingapp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bankingapp.Bankingapp.entity.UserModel;

public interface UserRepository extends JpaRepository<UserModel,UUID> {
    UserModel findByUserName(String userName);
}