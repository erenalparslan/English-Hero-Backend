package com.example.englishhero.English.Hero.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "word")
public class Word {

    @Id
    @GeneratedValue
    Long id;

    String turkishWord;

    String englishWord;

}
