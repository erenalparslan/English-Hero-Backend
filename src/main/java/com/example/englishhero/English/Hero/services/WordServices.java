package com.example.englishhero.English.Hero.services;

import com.example.englishhero.English.Hero.entities.Word;
import com.example.englishhero.English.Hero.repository.WordRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.JpaParametersParameterAccessor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  WordServices {


    WordRepository wordRepository;

    public WordServices(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public List<Word> getAllWord(){
        return wordRepository.findAll();
    }

    public Word postWord(Word word){
        return wordRepository.save(word);
    }


}
