package com.example.soham.usersignup.service;

import com.example.soham.usersignup.dto.UserDto;
import com.example.soham.usersignup.requestbody.UserRequest;
import com.example.soham.usersignup.responsebody.UserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
    public UserResponse createUser(UserRequest user);
}
