package com.example.goodnight.Review.repository;

import com.example.goodnight.Review.domain.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
//    @Query(value = "select r from Review r where r.title Like CONCAT('%', :title, '%') or r.content Like CONCAT('%', :content, '%')")
//    List<Review> findAllField(String title, String content, Pageable pageable);
//    List<Review> findReviewPage(Pageable pageable);
}
