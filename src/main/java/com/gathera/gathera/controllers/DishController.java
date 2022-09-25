package com.gathera.gathera.controllers;

import com.gathera.gathera.dtos.DishDTO;
import com.gathera.gathera.models.Dish;
import com.gathera.gathera.services.DishService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("restaurants/{restaurant_id}/dishes")
public class DishController {

    private final DishService dishService;

    DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping
    public List<Dish> index(@PathVariable Long restaurant_id) {
        return dishService.getAllDishes(restaurant_id);
    }

    @PostMapping
    public Dish store(@Valid @RequestBody DishDTO newDish, @PathVariable Long restaurant_id) {

        return dishService.createDish(newDish, restaurant_id);
    }

    @GetMapping({ "/{id}"})
    public Dish show(@PathVariable Long restaurant_id, @PathVariable(name = "id") Long id) {

        return dishService.getDishById(id);
    }

    @PutMapping({ "/{id}"})
    public Dish update(@PathVariable Long restaurant_id, @PathVariable(name = "id") Long id, @RequestBody DishDTO newDish) {

        return dishService.updateDish(id, newDish, restaurant_id);
    }

    @DeleteMapping({ "/{id}"})
    public void delete(@PathVariable(name = "id") Long id) {

        dishService.deleteDish(id);
    }
}
