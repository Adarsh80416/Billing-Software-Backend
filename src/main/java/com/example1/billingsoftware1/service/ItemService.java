package com.example1.billingsoftware1.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example1.billingsoftware1.io.ItemRequest;
import com.example1.billingsoftware1.io.ItemResponse;

public interface ItemService {

    ItemResponse add(ItemRequest request,MultipartFile file);

    List<ItemResponse> fetchItems();

    void deleteItems(String itemId);

}
