package com.example.englishhero.English.Hero.entities;

import com.example.englishhero.English.Hero.requests.UserRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "word")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long user_id;
    private String turkishWord;
    private String englishWord;


    // Getters and Setters (if not using Lombok)
}
