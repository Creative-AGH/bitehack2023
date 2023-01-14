package com.freecoders.server.entites;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany
    private List<Task> tasks;
}
