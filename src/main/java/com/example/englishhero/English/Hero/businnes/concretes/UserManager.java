package com.example.englishhero.English.Hero.businnes.concretes;


import com.example.englishhero.English.Hero.businnes.abstracts.UserService;
import com.example.englishhero.English.Hero.core.entities.User;
import com.example.englishhero.English.Hero.core.utilities.results.*;
import com.example.englishhero.English.Hero.entities.dtos.user.GetAllUserResponse;
import com.example.englishhero.English.Hero.dataAcces.abstracts.UserDao;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<GetAllUserResponse>> getAll() {
        try {
            List<User> user = this.userDao.findAll();
            List<GetAllUserResponse> usersDTO = new  ArrayList<>();
            
            for (User temp : user) {
                List<SimpleGrantedAuthority> authorities = temp.getAuthorities()
                .stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
                .collect(Collectors.toList());
                    var userDTO = GetAllUserResponse.builder()
                        .id(temp.getId())
                        .email(temp.getEmail())
                        .name(temp.getName())
                        .roles(authorities)
                        .build();
                        usersDTO.add(userDTO);
            }
            
            return new SuccessDataResult<List<GetAllUserResponse>>(usersDTO,"User data listed");
        } catch (Exception e) {
            return new ErrorDataResult<List<GetAllUserResponse>>("Error: " + e.getMessage());
        }
    }

    @Override
    public DataResult<User> getById(int id) {
        User user = this.userDao.findById(id).orElse(null);
        try {
            return new SuccessDataResult<User>(user, "User data listed");
        } catch (Exception e) {
            return new ErrorDataResult<User>(e.getMessage());
        }
    }

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("User added successfully");
    }

    @Override
    public Result update(User user) {
        this.userDao.save(user);
        return new SuccessResult("User update successfully");
    }

    @Override
    public Result delete(int id) {
        this.userDao.deleteById(id);
        return new SuccessResult("User deleted");
    }

    @Override
    public DataResult<User> getByEmail(String email) {
        Optional<User> user = userDao.findByEmail(email);

        if (user != null) {
            return new SuccessDataResult<User>(user.get(), "User found.");
        }
        return new ErrorDataResult<>("User not found.");
    }

}
