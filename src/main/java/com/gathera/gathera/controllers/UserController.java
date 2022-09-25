package com.gathera.gathera.controllers;

import com.gathera.gathera.models.User;
import com.gathera.gathera.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping(value = "/", consumes = {"application/json"})
    public User create(@RequestBody User newUser) {
        newUser.setCreatedAt(LocalDateTime.now());
        newUser.setUpdatedAt(LocalDateTime.now());
        return repository.save(newUser);
    }
}
