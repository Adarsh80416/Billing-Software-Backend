package com.example1.billingsoftware1.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
	String uploadFile(MultipartFile file);
	
	boolean deleteFile(String imgUrl);
}
