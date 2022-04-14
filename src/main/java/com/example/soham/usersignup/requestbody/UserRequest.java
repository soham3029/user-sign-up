package com.example.soham.usersignup.requestbody;

import com.example.soham.usersignup.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private UserDto userDto;
}
