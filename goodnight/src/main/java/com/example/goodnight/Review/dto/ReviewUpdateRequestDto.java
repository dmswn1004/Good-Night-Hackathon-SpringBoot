package com.example.goodnight.Review.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
public class ReviewUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public ReviewUpdateRequestDto(String title, String content){
        this.title = title;
        this.content = content;
    }
}
