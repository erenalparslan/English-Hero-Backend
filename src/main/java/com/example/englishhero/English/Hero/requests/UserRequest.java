package com.example.englishhero.English.Hero.requests;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserRequest {
    @Id
    @GeneratedValue
    Long id;

    String name;
    String surname;

    public UserRequest(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
}
