package com.oslomet.productapi.utility;

import com.oslomet.productapi.models.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

public class BlackFridaySale {

    @Value("${blackfriday.sale.discount}")
    private Integer blackFridaySaleDiscount;

    public List<Product> getBlackFridaySaleUpdatedPrice(List<Product> products){
        //Apply % Discount to all the prices of products
        products.forEach(p -> p.setPrice(p.getPrice() - ((p.getPrice() * 40)/100)));
        return products;
    }

}
