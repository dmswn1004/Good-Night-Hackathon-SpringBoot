package com.example.goodnight.Restaurant.domain.entity;

import com.example.goodnight.global.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "restaurant")
public class Restaurant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "is_activated", nullable = false)
    private boolean isActivated;

    @Builder
    public Restaurant(String name, String category, boolean isActivated) {
        this.name = name;
        this.category = category;
        this.isActivated = true;
    }

    public void update(String category) {
        this.category = category;
    }

    public void delete() {
        this.isActivated = false;
    }
}
