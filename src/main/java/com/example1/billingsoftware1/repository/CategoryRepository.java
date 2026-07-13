package com.example1.billingsoftware1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example1.billingsoftware1.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long>{
		Optional<CategoryEntity>findByCategoryId(String categoryId);
}
