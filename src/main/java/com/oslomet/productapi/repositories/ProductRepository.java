package com.oslomet.productapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oslomet.productapi.models.Product;
public interface ProductRepository extends JpaRepository<Product, Long>{
}
