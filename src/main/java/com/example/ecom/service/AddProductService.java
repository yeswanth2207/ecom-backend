package com.example.ecom.service;

import com.example.ecom.entity.AddProduct;
import com.example.ecom.repository.AddProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddProductService {

    @Autowired
    private AddProductRepository addProductRepository;

    public AddProduct saveProduct(AddProduct addProduct) {
        return addProductRepository.save(addProduct);
    }

    public AddProduct getProductByName(String name) {
        return addProductRepository.findById(name).orElse(null);
    }
}