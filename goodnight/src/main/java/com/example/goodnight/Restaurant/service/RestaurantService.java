package com.example.goodnight.Restaurant.service;

import com.example.goodnight.Restaurant.domain.entity.Restaurant;
import com.example.goodnight.Restaurant.dto.RestaurantCreateRequestDto;
import com.example.goodnight.Restaurant.dto.RestaurantResponseDto;
import com.example.goodnight.Restaurant.dto.RestaurantUpdateRequestDto;
import com.example.goodnight.Restaurant.repository.RestaurantRepository;
import lombok.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    // 레스토랑 등록
    @Transactional
    public void registration(RestaurantCreateRequestDto dto) {
        restaurantRepository.save(dto.toEntity());
    }

    // 레스토랑 목록 조회
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    // 레스토랑 카테고리에 따른 레스토랑 목록 조회
    public List<Restaurant> findAllByCategory(String category) {
        return restaurantRepository.findAllByCategory(category);
    }

    // 레스토랑 조회
    public RestaurantResponseDto findById(Long id) throws Exception {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(
                () -> new Exception("레스토랑을 찾을 수 없습니다."));
        RestaurantResponseDto dto = RestaurantResponseDto.builder()
                .name(restaurant.getName())
                .category(restaurant.getCategory())
                .createdAt(restaurant.getCreatedAt())
                .build();
        return dto;
    }

    // 레스토랑 수정
    @Transactional
    public void update(Long id, RestaurantUpdateRequestDto dto) throws Exception {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(
                () -> new Exception("레스토랑을 찾을 수 없습니다."));
        restaurant.update(dto.getCategory());
    }

    // 레스토랑 삭제
    @Transactional
    public void delete(Long id) throws Exception {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(
                () -> new Exception("레스토랑을 찾을 수 없습니다."));
        restaurant.delete();
    }
}
