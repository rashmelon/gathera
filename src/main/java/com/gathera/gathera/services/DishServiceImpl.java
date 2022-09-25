package com.gathera.gathera.services;

import com.gathera.gathera.dtos.DishDTO;
import com.gathera.gathera.exceptions.ModelNotFoundException;
import com.gathera.gathera.models.Dish;
import com.gathera.gathera.models.Restaurant;
import com.gathera.gathera.repositories.DishRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishService{

    private final DishRepository dishRepository;

    private final RestaurantService restaurantService;

    public DishServiceImpl(DishRepository dishRepository, RestaurantService restaurantService) {
        super();
        this.dishRepository = dishRepository;
        this.restaurantService = restaurantService;
    }

    @Override
    public List<Dish> getAllDishes(Long restaurantId) {
        return (List<Dish>) dishRepository.findAllByRestaurantId(restaurantId);
    }

    @Override
    public Dish createDish(DishDTO dishDTO, Long restaurantId) {
        Dish dish = new Dish();
        dishDTO.fillModel(dish);
        dish.setCreatedAt(LocalDateTime.now());
        dish.setUpdatedAt(LocalDateTime.now());
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        dish.setRestaurant(restaurant);

        return dishRepository.save(dish);
    }

    @Override
    public Dish updateDish(Long id, DishDTO dishDTO, Long restaurantId) {
        Dish dish = dishRepository.findById(id)
                .orElseThrow(ModelNotFoundException::new);
        dishDTO.fillModel(dish);
        dish.setUpdatedAt(LocalDateTime.now());
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        dish.setRestaurant(restaurant);


        return dishRepository.save(dish);
    }

    @Override
    public void deleteDish(Long id) {
        Dish dish = dishRepository.findById(id)
                .orElseThrow(ModelNotFoundException::new);

        dishRepository.delete(dish);
    }

    @Override
    public Dish getDishById(Long id) throws ModelNotFoundException {
        Optional<Dish> result = dishRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new ModelNotFoundException();
        }
    }
}
