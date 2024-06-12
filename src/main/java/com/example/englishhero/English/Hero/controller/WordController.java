package com.example.englishhero.English.Hero.controller;

import com.example.englishhero.English.Hero.entities.Word;
import com.example.englishhero.English.Hero.services.WordServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WordController {

    WordServices wordServices;

    public WordController(WordServices wordServices) {
        this.wordServices = wordServices;
    }

    @GetMapping("/words")
    List<Word> getAllWord(){
        return wordServices.getAllWord();
    }

    @PostMapping
    Word postWord(@RequestBody Word word){
        return wordServices.postWord(word);
    }

}
