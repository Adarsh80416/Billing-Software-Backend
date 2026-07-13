package com.example1.billingsoftware1.service;

import java.util.List;

import com.example1.billingsoftware1.io.UserRequest;
import com.example1.billingsoftware1.io.UserResponse;

public interface UserService {

    UserResponse createUser(UserRequest request);

    String getUserRole(String email);

    List<UserResponse> readUsers();

    void deleteUser(String id);
	
	

}
