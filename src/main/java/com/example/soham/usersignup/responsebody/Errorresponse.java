package com.example.soham.usersignup.responsebody;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Errorresponse {
    private Integer statusCode;
    private String message;
}
