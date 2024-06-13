package com.example.englishhero.English.Hero.services;

import com.example.englishhero.English.Hero.entities.User;
import com.example.englishhero.English.Hero.entities.Word;
import com.example.englishhero.English.Hero.repository.UserRepository;
import com.example.englishhero.English.Hero.repository.WordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordServices {


    WordRepository wordRepository;
    UserRepository userRepository;


    public WordServices(UserRepository userRepository, WordRepository wordRepository) {
        this.userRepository = userRepository;
        this.wordRepository = wordRepository;
    }

    public List<Word> getAllWord() {
        return wordRepository.findAll();
    }

    public Word postWord(Word word) {
        User user = userRepository.findById(word.getUser_id()).orElse(null);
        if (user == null) {
            return null;
        } else {
            wordRepository.save(word);
            return word;
        }

    }

}
