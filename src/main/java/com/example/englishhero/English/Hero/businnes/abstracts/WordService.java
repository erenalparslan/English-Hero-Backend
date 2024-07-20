package com.example.englishhero.English.Hero.businnes.abstracts;


import com.example.englishhero.English.Hero.core.utilities.results.DataResult;
import com.example.englishhero.English.Hero.core.utilities.results.Result;
import com.example.englishhero.English.Hero.entities.Word;

import java.util.List;

public interface WordService {
    DataResult<List<Word>> getAll();
    DataResult<Word> getById(int id);
    Result add(Word word);
    Result update(Word word);
    Result delete(int id);

}
