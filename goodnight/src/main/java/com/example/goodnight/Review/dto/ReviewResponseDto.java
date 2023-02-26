package com.example.goodnight.Review.dto;

import com.example.goodnight.Restaurant.domain.entity.Restaurant;
import lombok.*;

@Getter
@Builder
public class ReviewResponseDto {
    private String title;
    private String content;
    private String name;

    public ReviewResponseDto(String title, String content, String name) {
        this.title = title;
        this.content = content;
        this.name = name;
    }
}
