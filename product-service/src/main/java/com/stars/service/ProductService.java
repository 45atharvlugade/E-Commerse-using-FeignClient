package com.stars.service;

import com.stars.client.ReviewsClient;
import com.stars.dto.ProductDTO;
import com.stars.dto.ProductWithReviews;
import com.stars.dto.ReviewDTO;
import com.stars.model.Product;
import com.stars.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ReviewsClient reviewsClient;


    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    // Get single product with reviews
    public ProductWithReviews getProductWithReviews(String id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        List<ReviewDTO> reviewDTOList =
                reviewsClient.getReviewsByProductId(product.getProductId());

        ProductWithReviews productWithReviews = ProductWithReviews.builder()
                .product(product)
                .reviews(reviewDTOList)
                .build();

        productWithReviews.calculateAverageRating();

        return productWithReviews;
    }


    // Get all products with their reviews
    public List<ProductWithReviews> getAllProductWithReviews() {

        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(product -> {

                    List<ReviewDTO> reviews =
                            reviewsClient.getReviewsByProductId(
                                    product.getProductId()
                            );

                    ProductWithReviews productWithReviews =
                            ProductWithReviews.builder()
                                    .product(product)
                                    .reviews(reviews)
                                    .build();

                    productWithReviews.calculateAverageRating();

                    return productWithReviews;
                })
                .toList();
    }


    // Create product
    public void createProduct(ProductDTO dto) {

        Product product = Product.builder()
                .productName(dto.getProductName())
                .price(dto.getPrice())
                .category(dto.getCategory())
                .imageURL(dto.getImageURL())
                .stockQuantity(dto.getStockQuantity())
                .build();

        productRepository.save(product);
    }


    // Get products by category
    public List<Product> getProductsByCategory(String category) {

        return productRepository.findByCategory(category);
    }
}