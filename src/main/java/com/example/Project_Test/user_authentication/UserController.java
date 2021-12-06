package com.example.Project_Test.user_authentication;

import java.util.List;
import java.util.Map;

import com.example.Project_Test.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = "application/json")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(produces = "application/json")
    @RequestMapping(path = "/validateLogin" )
    public Map<String, String> validateLogin(){
        return userService.getValidatedUser();
    }


}
