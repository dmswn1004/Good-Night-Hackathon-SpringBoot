package com.example.goodnight.Restaurant.repository;

import com.example.goodnight.Restaurant.domain.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    @Query(value = "select r from Restaurant r where r.isActivated = true")
    List<Restaurant> findAll();

    @Query(value = "select r from Restaurant r where r.category = :category and r.isActivated = true")
    List<Restaurant> findAllByCategory(@Param("category") String category);

    @Query(value = "select r from Restaurant r where r.id = :id and r.isActivated = true")
    Optional<Restaurant> findById(Long id);
}
