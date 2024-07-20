package com.example.englishhero.English.Hero.controller;

import com.example.englishhero.English.Hero.businnes.abstracts.WordService;
import com.example.englishhero.English.Hero.core.utilities.results.DataResult;
import com.example.englishhero.English.Hero.core.utilities.results.Result;
import com.example.englishhero.English.Hero.entities.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/word")
public class WordController {

    private WordService wordService;


    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/getAllWords")
    ResponseEntity<DataResult<List<Word>>> getAllWord() {
        try {
            DataResult<List<Word>> result = wordService.getAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/post")
    ResponseEntity<Result> postWord(@RequestBody Word word) {
        try {
            Result result = wordService.add(word);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Result> update(@RequestBody Word word) {
        Result result = wordService.update(word);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Result> delete(@PathVariable int id) {
        Result result = wordService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
