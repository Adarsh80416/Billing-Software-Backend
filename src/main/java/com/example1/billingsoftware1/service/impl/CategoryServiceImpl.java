package com.example1.billingsoftware1.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example1.billingsoftware1.entity.CategoryEntity;
import com.example1.billingsoftware1.io.CategoryRequest;
import com.example1.billingsoftware1.io.CategoryResponse;
import com.example1.billingsoftware1.repository.CategoryRepository;
import com.example1.billingsoftware1.repository.ItemRepository;
import com.example1.billingsoftware1.service.CategoryService;
import com.example1.billingsoftware1.service.FileUploadService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    // ✅ DO NOT initialize
    private final CategoryRepository categoryRepository;
    
    private final FileUploadService fileUploadService;

    private final ItemRepository itemRepository;

    @Override
    public CategoryResponse add(CategoryRequest request,MultipartFile file) {
    	String imgUrl=fileUploadService.uploadFile(file);
        CategoryEntity newCategory = convertToEntity(request);
        newCategory.setImgUrl(imgUrl);
        newCategory = categoryRepository.save(newCategory);

        return convertToResponse(newCategory);
    }
    
    @Override
    public List<CategoryResponse> read(){
    	return categoryRepository.findAll()
    			.stream()
    			.map(categoryEntity -> convertToResponse(categoryEntity))
    			.collect(Collectors.toList());
    }
    @Override
    public void delete(String categoryId) {
    	CategoryEntity existingCategory=categoryRepository.findByCategoryId(categoryId)
    	.orElseThrow(()->new RuntimeException("Category not found"+categoryId));
    	 fileUploadService.deleteFile(existingCategory.getImgUrl());
    	categoryRepository.delete(existingCategory);
    }

    private CategoryResponse convertToResponse(CategoryEntity category) {
       Integer itemsCount=itemRepository.countByCategoryId(category.getId());
        return CategoryResponse.builder()
                .categoryId(category.getCategoryId())
                .name(category.getName())
                .description(category.getDescription())
                .bgcolor(category.getBgcolor())
                .createdAt(category.getCreatedAt())
                .updatedAt(category.getUpdatedAt())
                .imgUrl(category.getImgUrl())
                .items(itemsCount)
                .build();
    }

    private CategoryEntity convertToEntity(CategoryRequest request) {
        return CategoryEntity.builder()
                .categoryId(UUID.randomUUID().toString())
                .name(request.getName())
                .description(request.getDescription())
                .bgcolor(request.getBgcolor())
                .build();
    }
}
