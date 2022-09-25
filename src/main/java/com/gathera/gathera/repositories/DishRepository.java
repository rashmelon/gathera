package com.gathera.gathera.repositories;

import com.gathera.gathera.models.Dish;
import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends CrudRepository<Dish, Long> {
    Iterable<Dish> findAllByRestaurantId(Long restaurantId);
}
