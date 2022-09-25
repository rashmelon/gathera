package com.gathera.gathera.controllers;

import com.gathera.gathera.dtos.RestaurantDTO;
import com.gathera.gathera.exceptions.ModelNotFoundException;
import com.gathera.gathera.models.Restaurant;
import com.gathera.gathera.services.RestaurantService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Restaurant> index() {
        return restaurantService.getAllRestaurants();
    }

    @PostMapping
    public Restaurant store(@Valid @RequestBody RestaurantDTO newRestaurant) {

        return restaurantService.createRestaurant(newRestaurant);
    }

    @GetMapping({ "/{id}"})
    public Restaurant show(@PathVariable(name = "id") Long id) {

        return restaurantService.getRestaurantById(id);
    }

    @PutMapping({ "/{id}"})
    public Restaurant update(@PathVariable(name = "id") Long id, @RequestBody RestaurantDTO newRestaurant) {

        return restaurantService.updateRestaurant(id, newRestaurant);
    }

    @DeleteMapping({ "/{id}"})
    public void delete(@PathVariable(name = "id") Long id) {

        restaurantService.deleteRestaurant(id);
    }
}
