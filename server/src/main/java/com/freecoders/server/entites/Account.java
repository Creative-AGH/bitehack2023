package com.freecoders.server.entites;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany
    List<Availability> availabilities;

    @OneToMany
    List<Plan> plan;

}
