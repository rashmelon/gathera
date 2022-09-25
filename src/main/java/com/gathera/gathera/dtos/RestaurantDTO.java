package com.gathera.gathera.dtos;

import com.gathera.gathera.models.Restaurant;
import lombok.Data;

@Data
public class RestaurantDTO implements DTO<Restaurant>{
    private Long ownerId;

    private String name;

    private String hotline;

    private String workingHours;

    private float deliveryFees;

    public void fillModel(Restaurant restaurant) {
        restaurant.setName(name);
        restaurant.setHotline(hotline);
        restaurant.setWorkingHours(workingHours);
        restaurant.setDeliveryFees(deliveryFees);
    }
}
