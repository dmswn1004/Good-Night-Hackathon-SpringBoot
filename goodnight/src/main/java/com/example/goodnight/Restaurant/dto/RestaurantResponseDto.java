package com.example.goodnight.Restaurant.dto;

import com.example.goodnight.Restaurant.domain.entity.Restaurant;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Builder
public class RestaurantResponseDto {
    private String name;
    private String category;
    private LocalDateTime createdAt;

    public RestaurantResponseDto(String name,  String category, LocalDateTime createdAt) {
        this.name = name;
        this.category = category;
        this.createdAt = createdAt;
    }
 }
