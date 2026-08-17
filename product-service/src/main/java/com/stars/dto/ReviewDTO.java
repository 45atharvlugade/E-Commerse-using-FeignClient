package com.stars.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReviewDTO {
    private String id;
    private String productId;
    private String userName;
    private String comment;
    private Integer rating;
    private LocalDateTime createdAt;

}
