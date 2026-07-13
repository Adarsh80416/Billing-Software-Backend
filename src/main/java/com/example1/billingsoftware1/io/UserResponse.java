package com.example1.billingsoftware1.io;

import java.sql.Timestamp;   // ✅ CHANGED (was Time)

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private String userId;
    private String name;
    private String email;


    private Timestamp createdAt;   // ✅ CHANGED TYPE
    private Timestamp updatedAt;   // ✅ CHANGED TYPE

    private String role;
}