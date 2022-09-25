package com.gathera.gathera.repositories;

import com.gathera.gathera.models.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
}
