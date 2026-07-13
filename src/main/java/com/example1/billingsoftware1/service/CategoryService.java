package com.example1.billingsoftware1.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example1.billingsoftware1.io.CategoryRequest;
import com.example1.billingsoftware1.io.CategoryResponse;

public interface CategoryService {
	CategoryResponse add(CategoryRequest request,MultipartFile file);
	
	List<CategoryResponse> read();
	
	void delete(String categoryId);

}
