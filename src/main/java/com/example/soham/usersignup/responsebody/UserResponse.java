package com.example.soham.usersignup.responsebody;

import com.example.soham.usersignup.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private String message;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
}
