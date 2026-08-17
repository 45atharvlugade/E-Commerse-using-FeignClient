package com.stars.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
    private String productName;
    private String category;
    private String imageURL;
    private Double price;
    private Integer stockQuantity;
}
