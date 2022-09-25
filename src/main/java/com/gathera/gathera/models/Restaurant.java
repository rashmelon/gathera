package com.gathera.gathera.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity(name="restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User owner;

    @Column(nullable = false)
    private String name;

    @Column
    private String imageUrl;

    @Column
    private String hotline;

    @Column
    private String workingHours;

    @Column(nullable = false)
    private float deliveryFees;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public Restaurant(User owner, String name, String hotline, String workingHours, float deliveryFees) {
        this.owner = owner;
        this.name = name;
        this.hotline = hotline;
        this.workingHours = workingHours;
        this.deliveryFees = deliveryFees;
    }

    public Restaurant(){

    }
}
