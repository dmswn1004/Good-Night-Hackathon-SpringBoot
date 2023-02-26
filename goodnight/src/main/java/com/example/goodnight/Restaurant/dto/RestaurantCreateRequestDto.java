package com.example.goodnight.Restaurant.dto;

import com.example.goodnight.Restaurant.domain.entity.Restaurant;
import lombok.*;

@Getter
@NoArgsConstructor
public class RestaurantCreateRequestDto {
    private String name;
    private String category;

    public Restaurant toEntity() {
        return Restaurant.builder()
                .name(name)
                .category(category)
                .build();
    }
}
