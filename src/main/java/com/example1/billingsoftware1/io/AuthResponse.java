package com.example1.billingsoftware1.io;


import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class AuthResponse {

    private String email;
    private String token;
    private String role;

}
