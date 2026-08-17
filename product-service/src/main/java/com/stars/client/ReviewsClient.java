package com.stars.client;

import com.stars.dto.ReviewDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(
        name = "review-service",
        url = "http://localhost:8081"
)
public interface ReviewsClient {

    @GetMapping("/api/reviews/product/{productId}")
    List<ReviewDTO> getReviewsByProductId(
            @PathVariable("productId") String productId
    );
}