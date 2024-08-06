package com.example.ecom.repository;

import com.example.ecom.entity.AddProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddProductRepository extends JpaRepository<AddProduct, String> {
}
