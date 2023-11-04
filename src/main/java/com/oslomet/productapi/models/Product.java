package com.oslomet.productapi.models;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "PRODUCTS")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private String name;

  private String description;

  private Double price;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  public Product(String name, String description, Double price) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.setUpdatedAt(LocalDateTime.now());
    this.setUpdatedAt(LocalDateTime.now());
  }
}
