package com.example1.billingsoftware1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example1.billingsoftware1.entity.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

    Optional<ItemEntity> findByItemId(String id);

    Integer countByCategoryId(Long id);

}
