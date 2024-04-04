package com.Bankingapp.Bankingapp.entity;

import java.util.UUID;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@SuppressWarnings("deprecation")
@Data
@Entity
public class UserModel {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "user_id")
    @NotNull
    private UUID id;

    @NotNull
    // @Size(min= 5 , max=13)
    private String userName;
 
    @NotNull
    // @Size(min = 5,max = 13)
    private String password;

}