package com.example.englishhero.English.Hero.businnes.abstracts;



import com.example.englishhero.English.Hero.core.entities.User;
import com.example.englishhero.English.Hero.core.utilities.results.DataResult;
import com.example.englishhero.English.Hero.core.utilities.results.Result;
import com.example.englishhero.English.Hero.entities.dtos.user.GetAllUserResponse;


import java.util.List;

public interface UserService {
    DataResult<List<GetAllUserResponse>> getAll();
    DataResult<User> getById(int id);
    DataResult<User> getByEmail(String email);
    Result add(User user);
    Result update(User user);
    Result delete(int id);

}
