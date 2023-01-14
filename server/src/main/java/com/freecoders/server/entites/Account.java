package com.freecoders.server.entites;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    Long id;
    String email;
    String password;

    @Enumerated
    Role role;


}
