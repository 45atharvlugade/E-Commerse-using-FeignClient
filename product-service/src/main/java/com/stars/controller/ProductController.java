package com.stars.controller;

import com.stars.dto.ProductDTO;
import com.stars.dto.ProductWithReviews;
import com.stars.model.Product;
import com.stars.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {

        return ResponseEntity.ok(
                productService.getAllProducts()
        );
    }


    // SINGLE Feign Call
    @GetMapping("/{productId}/with-reviews")
    public ResponseEntity<ProductWithReviews> getProductWithReviews(
            @PathVariable String productId
    ) {

        ProductWithReviews response =
                productService.getProductWithReviews(productId);

        return ResponseEntity.ok(response);
    }


    // ALL PRODUCTS WITH REVIEWS
    @GetMapping("/with-reviews")
    public ResponseEntity<List<ProductWithReviews>> getAllProductWithReviews() {

        return ResponseEntity.ok(
                productService.getAllProductWithReviews()
        );
    }


    // CREATE PRODUCT
    @PostMapping("/create")
    public ResponseEntity<String> createProduct(
            @RequestBody ProductDTO dto
    ) {

        productService.createProduct(dto);

        return ResponseEntity.ok("Product created successfully");
    }


    // PRODUCTS BY CATEGORY
    @GetMapping("/{category}/products-with-category")
    public ResponseEntity<List<Product>> getProductsByCategory(
            @PathVariable String category
    ) {

        return ResponseEntity.ok(
                productService.getProductsByCategory(category)
        );
    }
}