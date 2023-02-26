package com.example.goodnight.Review.controller;

import com.example.goodnight.Review.domain.entity.Review;
import com.example.goodnight.Review.dto.ReviewCreateRequestDto;
import com.example.goodnight.Review.dto.ReviewResponseDto;
import com.example.goodnight.Review.dto.ReviewUpdateRequestDto;
import com.example.goodnight.Review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

//    @GetMapping("api/v1/reviews")
//    public List<Review> findAll(
//            @RequestParam(required = false) Optional<Integer> page,
//            @RequestParam(required = false) Optional<Integer> size,
//            @RequestParam(required = false) Optional<String> title,
//            @RequestParam(required = false) Optional<String> content,
//            @RequestParam(required = false) Optional<Boolean> descending
//    ) {
//        return reviewService.findAll(
//                page.orElse(0),
//                size.orElse(10),
//                title.orElse(""),
//                content.orElse(""),
//                descending.orElse(false)
//        );
//    }
    @PostMapping("/api/v1/reviews")
    public List<Review> findAll() {
        return reviewService.findAll();
    }

//    @GetMapping("/api/v1/reviews/")
//    public void index(@PageableDefault(size = 10, sort="createdAt", direction = Sort.Direction.ASC)Pageable pageable) {
//        reviewService.findReviewPage(pageable);
//    }

    @GetMapping("/api/v1/reviews/{id}")
    public ReviewResponseDto findById(@PathVariable Long id) {
        return reviewService.findById(id);
    }

    @PostMapping("/api/v1/reviews/new")
    public void addReview(@RequestBody ReviewCreateRequestDto dto) {
        reviewService.reregistration(dto);
    }

    @PutMapping("/api/v1/reviews/update/{id}")
    public void update(@PathVariable Long id,@RequestBody ReviewUpdateRequestDto dto){
        reviewService.update(id, dto);
    }

    @DeleteMapping("/api/v1/reviews/delete/{id}")
    public void delete(@PathVariable Long id) {
        reviewService.delete(id);
    }
}
