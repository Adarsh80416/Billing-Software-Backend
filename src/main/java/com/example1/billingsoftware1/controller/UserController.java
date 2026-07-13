package com.example1.billingsoftware1.controller;

import java.util.List;

// ❌ WRONG IMPORT — REMOVE THIS
// import org.apache.http.HttpStatus;

// ✅ CORRECTED IMPORT — USE SPRING ONE
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example1.billingsoftware1.io.UserRequest;
import com.example1.billingsoftware1.io.UserResponse;
import com.example1.billingsoftware1.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse registerUser(@RequestBody UserRequest request) {
        try {
            return userService.createUser(request);
        } catch (Exception e) {
            // ✅ NOW WORKS
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "unable to create user " + e.getMessage());
        }
    }

    @GetMapping("/users")
    public List<UserResponse> readUsers() {
        return userService.readUsers();
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable String id) {
        try {
            userService.deleteUser(id);
        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "unable to delete user " + e.getMessage());
        }
    }
}