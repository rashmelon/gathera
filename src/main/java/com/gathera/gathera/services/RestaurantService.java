package com.gathera.gathera.services;

import com.gathera.gathera.dtos.RestaurantDTO;
import com.gathera.gathera.exceptions.ModelNotFoundException;
import com.gathera.gathera.models.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> getAllRestaurants();

    Restaurant createRestaurant(RestaurantDTO restaurantDTO);

    Restaurant updateRestaurant(Long id, RestaurantDTO restaurantDTO) throws ModelNotFoundException;

    void deleteRestaurant(Long id) throws ModelNotFoundException;

    Restaurant getRestaurantById(Long id) throws ModelNotFoundException;
}
