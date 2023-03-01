package com.example.goodnight.Review.controller;

import com.example.goodnight.Review.domain.entity.Review;
import com.example.goodnight.Review.dto.ReviewCreateRequestDto;
import com.example.goodnight.Review.dto.ReviewResponseDto;
import com.example.goodnight.Review.dto.ReviewUpdateRequestDto;
import com.example.goodnight.Review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("api/v1/reviews")
    @ResponseStatus(HttpStatus.OK)
    public List<Review> findAll(
            @Validated @RequestParam(required = false) Optional<Integer> page,
            @Validated @RequestParam(required = false) Optional<Integer> size,
            @RequestParam(required = false) Optional<String> title,
            @RequestParam(required = false) Optional<String> content,
            @RequestParam(required = false) Optional<Boolean> descending
    ) {
        return reviewService.findAllWithPagination(
                page.orElse(0),
                size.orElse(10),
                title.orElse(""),
                content.orElse(""),
                descending.orElse(false)
        );
    }

    @GetMapping("/api/v1/reviews/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReviewResponseDto findById(@PathVariable Long id) throws Exception {
        return reviewService.findById(id);
    }

    @PostMapping("/api/v1/reviews")
    @ResponseStatus(HttpStatus.CREATED)
    public void addReview(@Validated @RequestBody ReviewCreateRequestDto dto) {
        reviewService.reregistration(dto);
    }

    @PatchMapping("/api/v1/reviews/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@PathVariable Long id, @RequestBody ReviewUpdateRequestDto dto) throws Exception {
        reviewService.update(id, dto);
    }

    @DeleteMapping("/api/v1/reviews/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws Exception {
        reviewService.delete(id);
    }
}
