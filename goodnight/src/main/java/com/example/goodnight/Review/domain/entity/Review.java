package com.example.goodnight.Review.domain.entity;

import com.example.goodnight.Restaurant.domain.entity.Restaurant;
import com.example.goodnight.Review.dto.ReviewUpdateRequestDto;
import com.example.goodnight.global.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Table(name =  "review")
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @Builder
    public Review(Restaurant restaurant, String title, String content) {
        this.restaurant = restaurant;
        this.title = title;
        this.content = content;
    }

    public void update(ReviewUpdateRequestDto dto) {
        this.title = dto.getTitle();
        this.content = dto.getContent();
    }
}
