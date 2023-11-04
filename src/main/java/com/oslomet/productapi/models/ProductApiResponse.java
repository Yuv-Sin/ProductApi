package com.oslomet.productapi.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductApiResponse {

    private List<Product> products;
    private Boolean showProducts = false;
    private Boolean isBlackFridaySale = false;

    public ProductApiResponse(List<Product> products) {
        this.products = products;
    }
}