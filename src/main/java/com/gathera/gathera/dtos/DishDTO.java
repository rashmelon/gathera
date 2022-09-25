package com.gathera.gathera.dtos;

import com.gathera.gathera.models.Dish;
import lombok.Data;

@Data
public class DishDTO implements DTO<Dish>{
    private String name;

    private float price;

    public void fillModel(Dish dish) {
        dish.setName(name);
        dish.setPrice(price);
    }
}
