package com.example.englishhero.English.Hero.dataAcces.abstracts;

import com.example.englishhero.English.Hero.entities.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordDao extends JpaRepository<Word, Integer> {

}
