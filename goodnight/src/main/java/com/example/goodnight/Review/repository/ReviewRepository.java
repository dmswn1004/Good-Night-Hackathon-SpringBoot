package com.example.goodnight.Review.repository;

import com.example.goodnight.Review.domain.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query(value = "SELECT r\n " +
            "FROM Review r\n " +
            "WHERE (r.title = '' OR r.title Like CONCAT('%', :title, '%'))\n " +
            "AND (r.content = '' OR r.content Like CONCAT('%', :content, '%'))\n")
    List<Review> findAllWithFieldQuery(
            String title,
            String content,
            Pageable pageable
    );

}
