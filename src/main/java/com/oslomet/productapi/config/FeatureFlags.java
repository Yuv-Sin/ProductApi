package com.oslomet.productapi.config;


import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;

public enum FeatureFlags implements Feature{

  @Label("Price Decrease for BLACK FRIDAY SALE")
  BLACK_FRIDAY_SALE,

  @Label("Hide all products")
  HIDE_PRODUCTS;
}
