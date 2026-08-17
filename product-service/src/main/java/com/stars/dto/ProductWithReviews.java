package com.stars.dto;

import com.stars.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductWithReviews {

    private Product product;
    private List<ReviewDTO> reviews;
    private Integer totalReviews;
    private Double averagerating;

    // helper method to calculate the average ratings
    public void calculateAverageRating(){
        if(reviews!=null && !reviews.isEmpty()){
            this.averagerating = reviews.stream()
                    .mapToInt(ReviewDTO::getRating)
                    .average().orElse(0.0);

            this.totalReviews=reviews.size();

        }else{
            this.averagerating=0.0;
            this.totalReviews=0;
        }
    }

}
