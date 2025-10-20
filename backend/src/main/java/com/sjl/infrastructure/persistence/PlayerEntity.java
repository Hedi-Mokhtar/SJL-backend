package com.sjl.infrastructure.persistence;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "players")
public class PlayerEntity {

    @Id
    @GeneratedValue
    public UUID id;

    public String firstName;
    public String lastName;
    public String email;
    public String phoneNumber;
    public String licenseNumber;
    public String level;
    public boolean referee;
    public boolean manager;
}
