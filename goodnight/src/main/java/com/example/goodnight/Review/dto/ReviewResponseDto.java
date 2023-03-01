package com.example.goodnight.Review.dto;

import com.example.goodnight.Restaurant.domain.entity.Restaurant;
import lombok.*;

@Getter
public class ReviewResponseDto {
    private String title;
    private String content;
    private String name;

    @Builder
    public ReviewResponseDto(String title, String content, String name) {
        this.title = title;
        this.content = content;
        this.name = name;
    }
}
