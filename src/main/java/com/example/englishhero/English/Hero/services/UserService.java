package com.example.englishhero.English.Hero.services;

import com.example.englishhero.English.Hero.entities.User;
import com.example.englishhero.English.Hero.repository.UserRepository;
import com.example.englishhero.English.Hero.requests.UserRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserRequest> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(user -> new UserRequest(user.getId(), user.getName(), user.getUsername())).collect(Collectors.toList());
    }

    public User getUsersById(Long id) {

        return userRepository.findById(id).orElse(null);
    }

    public UserRequest postUsers(User user) {
        userRepository.save(user);
        return new UserRequest(user.getId(), user.getName(), user.getUsername());
    }
}
