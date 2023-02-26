package com.example.goodnight.Restaurant.controller;

import com.example.goodnight.Restaurant.domain.entity.Restaurant;
import com.example.goodnight.Restaurant.dto.RestaurantCreateRequestDto;
import com.example.goodnight.Restaurant.dto.RestaurantResponseDto;
import com.example.goodnight.Restaurant.dto.RestaurantUpdateRequestDto;
import com.example.goodnight.Restaurant.service.RestaurantService;
import lombok.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping("/api/v1/restaurants/new")
    public void addRestaurant(@RequestBody RestaurantCreateRequestDto dto){
        restaurantService.registration(dto);
    }

    @GetMapping("/api/v1/restaurants")
    public List<Restaurant> findAll() {
        return restaurantService.findAll();
    }

    @GetMapping("/api/v1/restaurants/{id}")
    public RestaurantResponseDto findById(@PathVariable Long id) {
        return restaurantService.findById(id);
    }

    @GetMapping("/api/v1/restaurants/list/{category}")
    public List<Restaurant> findAllByCategory(@RequestParam(value = "category") String category) {
        return restaurantService.findAllByCategory(category);
    }

    @PutMapping("/api/v1/restaurants/update/{id}")
    public void update(@PathVariable Long id, @RequestBody RestaurantUpdateRequestDto dto) {
        restaurantService.update(id, dto);
    }

    @DeleteMapping("/api/v1/restaurants/delete/{id}")
    public void delete(@PathVariable Long id) {
        restaurantService.delete(id);
    }

}
