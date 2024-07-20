package com.example.englishhero.English.Hero.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "word")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer user_id;
    private String turkishWord;
    private String englishWord;


    // Getters and Setters (if not using Lombok)
}
