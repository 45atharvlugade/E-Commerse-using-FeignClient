package com.stars.controller;

import com.stars.dto.ReviewDTO;
import com.stars.dto.ReviewRequest;
import com.stars.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    // Create a review
    @PostMapping("/{productId}")
    public ResponseEntity<String> writeReview(
            @PathVariable String productId,
            @RequestParam String userName,
            @RequestBody ReviewRequest request
    ) {

        reviewService.writeReveiw(userName, productId, request);

        return ResponseEntity.ok("Review created successfully");
    }

    // Get reviews by product ID
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ReviewDTO>> getReviewsByProductId(
            @PathVariable String productId
    ) {

        return ResponseEntity.ok(
                reviewService.getReviewsByProductId(productId)
        );
    }
}