package com.oslomet.productapi.service;

import com.oslomet.productapi.config.FeatureFlags;
import com.oslomet.productapi.models.Product;
import com.oslomet.productapi.models.ProductApiResponse;
import com.oslomet.productapi.repositories.ProductRepository;
import com.oslomet.productapi.utility.BlackFridaySale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.togglz.core.manager.FeatureManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService {

    @Autowired
    private FeatureManager featureManager;

    @Autowired
    private ProductRepository productRepository;

    private BlackFridaySale bfs = new BlackFridaySale();

   public ProductApiResponse getProducts(){

        List<Product> products = new ArrayList<>();
        products.addAll(productRepository.findAll());
        ProductApiResponse productApiResponse = new ProductApiResponse();
        if(featureManager.isActive(FeatureFlags.BLACK_FRIDAY_SALE)) {
            // Update sale price of each product
            products = bfs.getBlackFridaySaleUpdatedPrice(products);
            productApiResponse.setIsBlackFridaySale(true);
        }
        productApiResponse.setProducts(products);
        productApiResponse.setShowProducts(true);

        if(featureManager.isActive(FeatureFlags.HIDE_PRODUCTS)){
            // Hide all products from the API response
            productApiResponse.setProducts(null);
            productApiResponse.setShowProducts(false);
        }

        return productApiResponse;
   }

   public Product addProduct(Product product){
       product.setCreatedAt(LocalDateTime.now());
       product.setUpdatedAt(LocalDateTime.now());
       return productRepository.save(product);
   }
}
