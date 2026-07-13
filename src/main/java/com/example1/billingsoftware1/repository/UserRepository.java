package com.example1.billingsoftware1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example1.billingsoftware1.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    
    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByUserId(String userId);

}
