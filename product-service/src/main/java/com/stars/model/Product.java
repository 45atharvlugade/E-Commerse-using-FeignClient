package com.stars.model;


import jakarta.persistence.*;
import jdk.jfr.Category;

import  com.stars.enums.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proudct_table")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID )
    private String productId;
    private String productName;
    private String category;
    private String imageURL;
    private Double price;
    private Integer stockQuantity;
}
