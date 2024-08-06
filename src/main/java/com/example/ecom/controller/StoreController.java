package com.example.ecom.controller;

import com.example.ecom.entity.Product;
import com.example.ecom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoreController {

    @Autowired
    private ProductRepository productRepository;
    @CrossOrigin(origins = {"http://localhost:4200", "https://bitly.com"})
    @GetMapping("/products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}