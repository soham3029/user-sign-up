package com.example.soham.usersignup.controller;

import com.example.soham.usersignup.requestbody.UserRequest;
import com.example.soham.usersignup.responsebody.UserResponse;
import com.example.soham.usersignup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/createUser")
    public UserResponse createUser(@RequestBody UserRequest userRequest)
    {
        return userService.createUser(userRequest);
    }
    @PostMapping("/hallo")
    public String halloRest()
    {
        return "Hello rest world";
    }
}
