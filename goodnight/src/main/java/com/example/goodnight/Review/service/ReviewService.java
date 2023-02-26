package com.example.goodnight.Review.service;

import com.example.goodnight.Review.domain.entity.Review;
import com.example.goodnight.Review.dto.ReviewCreateRequestDto;
import com.example.goodnight.Review.dto.ReviewResponseDto;
import com.example.goodnight.Review.dto.ReviewUpdateRequestDto;
import com.example.goodnight.Review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    // 리뷰 목록 조회
    // 레스토랑 명, 리뷰 리스트를 내용을 반환합니다.
    // 리뷰 리스트는 등록 순이나 역순으로 조회할 수 있고 pagination을 지원하며, 리뷰 제목과 내용으로 검색할 수 있습니다.
//    public List<Review> findAll(Integer page, Integer size, String title, String content, Boolean descending) {
//        PageRequest pageRequest = PageRequest.of(page, size, descending? Sort.by("createdAt").descending() : Sort.by("createdAt").ascending());
//        return reviewRepository.findAllField(title, content, pageRequest);
//    }
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

//    public List<Review> findReviewPage(Pageable pageable) {
//        return reviewRepository.findReviewPage(pageable);
//    }

    // 리뷰 조회
    public ReviewResponseDto findById(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(null);
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
    public void update(Long id, ReviewUpdateRequestDto dto){
        Review review = reviewRepository.findById(id).orElseThrow(null);
        review.update(dto.getTitle(), dto.getContent());
    }

    // 리뷰 삭제
    @Transactional
    public void delete(Long id){
        Review review = reviewRepository.findById(id).orElseThrow(null);
        reviewRepository.delete(review);
    }
}
