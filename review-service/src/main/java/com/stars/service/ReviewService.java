package com.stars.service;

import com.stars.dto.ReviewDTO;
import com.stars.dto.ReviewRequest;
import com.stars.model.Review;
import com.stars.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public void writeReveiw(
            String userName,
            String productId,
            ReviewRequest request
    ) {

        Review review = Review.builder()
                .ratings(request.getRatings())
                .comment(request.getComment())
                .userName(userName)
                .productId(productId)
                .build();

        reviewRepository.save(review);
    }

    public List<ReviewDTO> getReviewsByProductId(String productId){
        return reviewRepository.findAllByProductId(productId)
                .stream()
                .map(this::toReviewDTO)
                .toList();
    }

   private ReviewDTO toReviewDTO(Review review) {
        return ReviewDTO.builder()
                .id(review.getId())
                .userName(review.getUserName())
                .rating(review.getRatings())
                .productId(review.getProductId())
                .comment(review.getComment())
                .createdAt(review.getCreatedAt())
                .build();
    }




}
