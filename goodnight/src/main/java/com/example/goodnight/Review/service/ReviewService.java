package com.example.goodnight.Review.service;

import com.example.goodnight.Review.domain.entity.Review;
import com.example.goodnight.Review.dto.ReviewCreateRequestDto;
import com.example.goodnight.Review.dto.ReviewResponseDto;
import com.example.goodnight.Review.dto.ReviewUpdateRequestDto;
import com.example.goodnight.Review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public List<Review> findAllWithPagination(
            Integer page,
            Integer size,
            String title,
            String content,
            boolean descending
    ) {
        PageRequest pageRequest = PageRequest.of(
                page, size, descending ? Sort.by("createdAt").descending() : Sort.by("createdAt").ascending()
        );

        return reviewRepository.findAllWithFieldQuery(title, content, pageRequest);
    }

    // 리뷰 조회
    public ReviewResponseDto findById(Long id) throws Exception {
        Review review = reviewRepository.findById(id).orElseThrow(() -> new Exception("리뷰를 찾을 수 없습니다."));
        ReviewResponseDto dto = ReviewResponseDto.builder()
                .title(review.getTitle())
                .content(review.getContent())
                .name(review.getRestaurant().getName())
                .build();
        return dto;
    }

    // 리뷰 작성
    @Transactional
    public void reregistration(ReviewCreateRequestDto dto){
        reviewRepository.save(dto.toEntity());
    }

    // 리뷰 수정
    @Transactional
    public void update(Long id, ReviewUpdateRequestDto dto) throws Exception {
        Review review = reviewRepository.findById(id).orElseThrow(() -> new Exception("리뷰를 찾을 수 없습니다."));
        review.update(dto);
    }

    // 리뷰 삭제
    @Transactional
    public void delete(Long id) throws Exception {
        Review review = reviewRepository.findById(id).orElseThrow(() -> new Exception("리뷰를 찾을 수 없습니다."));
        reviewRepository.delete(review);
    }
}
