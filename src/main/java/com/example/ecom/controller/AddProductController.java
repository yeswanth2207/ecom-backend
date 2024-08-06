package com.example.ecom.controller;

import com.example.ecom.entity.AddProduct;
import com.example.ecom.service.AddProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddProductController {

    @Autowired
    private AddProductService addProductService;
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addproducts")
    public ResponseEntity<?> createProduct(@RequestBody AddProduct addProduct) {
        try {
            if (addProductService.getProductByName(addProduct.getName()) != null) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Product already exists.");
            }
            AddProduct savedProduct = addProductService.saveProduct(addProduct);
            return ResponseEntity.ok(savedProduct);
        } catch (Exception ex) {
            // Log the exception
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + ex.getMessage());
        }
    }
}