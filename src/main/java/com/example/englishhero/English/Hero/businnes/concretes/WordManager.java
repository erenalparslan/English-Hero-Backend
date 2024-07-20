package com.example.englishhero.English.Hero.businnes.concretes;

import com.example.englishhero.English.Hero.businnes.abstracts.WordService;
import com.example.englishhero.English.Hero.core.entities.User;
import com.example.englishhero.English.Hero.core.utilities.results.*;
import com.example.englishhero.English.Hero.dataAcces.abstracts.UserDao;
import com.example.englishhero.English.Hero.dataAcces.abstracts.WordDao;
import com.example.englishhero.English.Hero.entities.Word;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordManager implements WordService {

    private WordDao wordDao;
    private UserDao userDao;

    public WordManager(WordDao wordDao, UserDao userDao) {
        this.wordDao = wordDao;
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<Word>> getAll() {
        try {
            List<Word> words = this.wordDao.findAll();
            return new SuccessDataResult<List<Word>>(words, "User data listed");
        } catch (Exception e) {
            return new ErrorDataResult<List<Word>>("Error: " + e.getMessage());
        }

    }

    @Override
    public DataResult<Word> getById(int id) {
        try {
            Word word = this.wordDao.findById(id).orElse(null);
            return new SuccessDataResult<Word>(word, "User data listed");
        } catch (Exception e) {
            return new ErrorDataResult<Word>("Error: " + e.getMessage());
        }
    }

    @Override
    public Result add(Word word) {
        User user = userDao.findById(word.getUser_id()).orElse(null);
        if (user == null || word.getEnglishWord().isEmpty()||word.getTurkishWord().isEmpty()||word.getEnglishWord().isBlank()||word.getTurkishWord().isBlank()) {
            return null;
        } else {
            this.wordDao.save(word);
            return new SuccessResult("Word added successfully");
        }
    }

    @Override
    public Result update(Word word) {
        this.wordDao.save(word);
        return new SuccessResult("User updated successfully");
    }

    @Override
    public Result delete(int id) {
        this.wordDao.deleteById(id);
        return new SuccessResult("Deleted word");
    }
}
