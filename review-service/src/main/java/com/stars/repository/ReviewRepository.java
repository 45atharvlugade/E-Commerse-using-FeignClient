package com.stars.repository;

import com.stars.dto.ReviewDTO;
import com.stars.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository  extends JpaRepository<Review,String> {

    List<Review> findAllByProductId(String productId);
}
