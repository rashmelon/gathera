package com.gathera.gathera.services;

import com.gathera.gathera.dtos.RestaurantDTO;
import com.gathera.gathera.exceptions.ModelNotFoundException;
import com.gathera.gathera.models.Restaurant;
import com.gathera.gathera.models.User;
import com.gathera.gathera.repositories.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    private final RestaurantRepository restaurantRepository;

    private final UserService userService;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, UserService userService) {
        super();
        this.restaurantRepository = restaurantRepository;
        this.userService = userService;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return (List<Restaurant>) restaurantRepository.findAll();
    }

    @Override
    public Restaurant createRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = new Restaurant();
        restaurantDTO.fillModel(restaurant);
        restaurant.setCreatedAt(LocalDateTime.now());
        restaurant.setUpdatedAt(LocalDateTime.now());
        User user = userService.getUserById(restaurantDTO.getOwnerId());
        restaurant.setOwner(user);

        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(Long id, RestaurantDTO restaurantDTO) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(ModelNotFoundException::new);
        restaurantDTO.fillModel(restaurant);
        restaurant.setUpdatedAt(LocalDateTime.now());
        User user = userService.getUserById(restaurantDTO.getOwnerId());
        restaurant.setOwner(user);

        return restaurantRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(ModelNotFoundException::new);

        restaurantRepository.delete(restaurant);
    }

    @Override
    public Restaurant getRestaurantById(Long id) throws ModelNotFoundException {
        Optional<Restaurant> result = restaurantRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new ModelNotFoundException();
        }
    }
}
