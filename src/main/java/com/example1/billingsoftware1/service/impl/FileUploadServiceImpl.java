package com.example1.billingsoftware1.service.impl;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.example1.billingsoftware1.service.FileUploadService;

import lombok.RequiredArgsConstructor;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    private final Cloudinary cloudinary;

    public FileUploadServiceImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public String uploadFile(MultipartFile file) {

        try {
            Map uploadResult = cloudinary.uploader()
                    .upload(file.getBytes(), Map.of());

            return uploadResult.get("url").toString();

        } catch (IOException e) {
            throw new RuntimeException("Image upload failed");
        }
    }

    @Override
    public boolean deleteFile(String imgUrl) {

        try {
            String publicId = imgUrl.substring(
                    imgUrl.lastIndexOf("/") + 1,
                    imgUrl.lastIndexOf(".")
            );

            cloudinary.uploader().destroy(publicId, Map.of());

            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
