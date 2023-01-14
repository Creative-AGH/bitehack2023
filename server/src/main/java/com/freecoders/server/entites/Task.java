package com.freecoders.server.entites;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //task ma date
    private String name;
    private String description;


}