package com.example.phamthanhdat.repository;

import com.example.phamthanhdat.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface  ProductRepository extends JpaRepository<Product,String> {
}
