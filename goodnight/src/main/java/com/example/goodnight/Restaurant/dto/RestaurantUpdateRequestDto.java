package com.example.goodnight.Restaurant.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class RestaurantUpdateRequestDto {
    private String category;

    @Builder
    public RestaurantUpdateRequestDto(String category) {
        this.category = category;
    }
}
