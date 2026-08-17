package com.stars.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(
        name="review"
)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String userName;
    private String productId;
    private String comment;
    private Integer ratings;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersit(){
        this.createdAt=LocalDateTime.now();
    }


}
