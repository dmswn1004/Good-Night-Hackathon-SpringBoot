package com.example.goodnight.Restaurant.controller;

import com.example.goodnight.Restaurant.domain.entity.Restaurant;
import com.example.goodnight.Restaurant.dto.RestaurantCreateRequestDto;
import com.example.goodnight.Restaurant.dto.RestaurantResponseDto;
import com.example.goodnight.Restaurant.dto.RestaurantUpdateRequestDto;
import com.example.goodnight.Restaurant.service.RestaurantService;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping("/api/v1/restaurants/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void addRestaurant(
            @Validated @RequestBody RestaurantCreateRequestDto dto){
        restaurantService.registration(dto);
    }

    @GetMapping("/api/v1/restaurants")
    @ResponseStatus(HttpStatus.OK)
    public List<Restaurant> findAll() {
        return restaurantService.findAll();
    }

    @GetMapping("/api/v1/restaurants/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RestaurantResponseDto findById(@PathVariable Long id) throws Exception {
        return restaurantService.findById(id);
    }

    @GetMapping("/api/v1/restaurants/category")
    @ResponseStatus(HttpStatus.OK)
    public List<Restaurant> findAllByCategory(@RequestParam String category) {
        return restaurantService.findAllByCategory(category);
    }

    @PatchMapping("/api/v1/restaurants/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@PathVariable Long id, @RequestBody RestaurantUpdateRequestDto dto) throws Exception {
        restaurantService.update(id, dto);
    }

    @DeleteMapping("/api/v1/restaurants/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws Exception {
        restaurantService.delete(id);
    }

}
