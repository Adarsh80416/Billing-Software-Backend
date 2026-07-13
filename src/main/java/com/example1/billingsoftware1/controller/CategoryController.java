package com.example1.billingsoftware1.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.example1.billingsoftware1.io.CategoryRequest;
import com.example1.billingsoftware1.io.CategoryResponse;
import com.example1.billingsoftware1.service.CategoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;


@RestController

@RequiredArgsConstructor



public class CategoryController {
    
    private final CategoryService categoryService;

    @PostMapping("/admin/categories")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse addCategory(
            @RequestPart("category") String categoryRequest,
            @RequestPart("file") MultipartFile file) {
    	ObjectMapper objectMapper=new ObjectMapper();
    	CategoryRequest request=null;
    	try {
            request = objectMapper.readValue(categoryRequest, CategoryRequest.class);
            return categoryService.add(request,file);
        } catch (JsonProcessingException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Exception occured while parsing json"+ex.getMessage());
        }
    	

        
    }
    @GetMapping("/categories")
    public List<CategoryResponse> fetchCategories(){
    	return categoryService.read();
    }
	
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/admin/categories/{categoryId}")
    public void remove(@PathVariable String categoryId) {
    	try {
    		categoryService.delete(categoryId);
    	}catch(Exception e) {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
    		
    	}
    	
    }
	

}
