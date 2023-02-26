package com.example.goodnight.Review.dto;

import com.example.goodnight.Restaurant.domain.entity.Restaurant;
import com.example.goodnight.Review.domain.entity.Review;
import lombok.*;

@Getter
@NoArgsConstructor
public class ReviewCreateRequestDto {
    private String title;
    private String content;
    private Restaurant restaurant;

    public Review toEntity() {
        return Review.builder()
                .title(title)
                .content(content)
                .restaurant(restaurant)
                .build();
    }
}
