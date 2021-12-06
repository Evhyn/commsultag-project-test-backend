package com.example.Project_Test.user_authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Map<String, String> getValidatedUser(){
        HashMap<String, String> map = new HashMap<>();
        map.put("response", "User Successfully Authenticated");
        return map;
    }
}
