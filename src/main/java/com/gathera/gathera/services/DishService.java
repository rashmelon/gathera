package com.gathera.gathera.services;

import com.gathera.gathera.dtos.DishDTO;
import com.gathera.gathera.exceptions.ModelNotFoundException;
import com.gathera.gathera.models.Dish;

import java.util.List;

public interface DishService {
    List<Dish> getAllDishes(Long restaurant_id);

    Dish createDish(DishDTO dishDTO, Long restaurant_id);

    Dish updateDish(Long id, DishDTO dishDTO, Long restaurant_id) throws ModelNotFoundException;

    void deleteDish(Long id) throws ModelNotFoundException;

    Dish getDishById(Long id) throws ModelNotFoundException;
}
