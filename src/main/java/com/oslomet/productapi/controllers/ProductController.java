package com.oslomet.productapi.controllers;

import java.time.LocalDateTime;

import com.oslomet.productapi.models.Product;
import com.oslomet.productapi.models.ProductApiResponse;
import com.oslomet.productapi.repositories.ProductRepository;
import com.oslomet.productapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.togglz.core.manager.FeatureManager;

import com.oslomet.productapi.config.FeatureFlags;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController{

    @Autowired
    private ProductService productService;

    @CrossOrigin
    @GetMapping("/getProducts")
    public ProductApiResponse getProducts(){
      return productService.getProducts();
    }


    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

}
