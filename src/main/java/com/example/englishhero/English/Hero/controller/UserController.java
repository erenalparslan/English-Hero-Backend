package com.example.englishhero.English.Hero.controller;

import com.example.englishhero.English.Hero.businnes.abstracts.UserService;
import com.example.englishhero.English.Hero.core.entities.User;
import com.example.englishhero.English.Hero.core.utilities.results.DataResult;
import com.example.englishhero.English.Hero.core.utilities.results.ErrorDataResult;
import com.example.englishhero.English.Hero.core.utilities.results.Result;
import com.example.englishhero.English.Hero.entities.dtos.user.GetAllUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    ResponseEntity<DataResult<List<GetAllUserResponse>>> getAllUser() {
        try {
            DataResult<List<GetAllUserResponse>> result = userService.getAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{userId}")
    ResponseEntity<DataResult<User>> getUserById(@PathVariable int userId) {
        try {
            DataResult<User> result = userService.getById(userId);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody User user) {
        Result result = userService.add(user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Result> update(@RequestBody User user) {
        Result result = userService.update(user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Result> delete(@PathVariable int id) {
        Result result = userService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/get{email}")
    public ResponseEntity<DataResult<User>> getByEmail(@PathVariable String email) {
        try {
            DataResult<User> result = userService.getByEmail(email);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDataResult<>("Something went wrong when getting the user by email"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
