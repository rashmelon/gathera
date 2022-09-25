package com.gathera.gathera.services;

import com.gathera.gathera.dtos.UserDTO;
import com.gathera.gathera.exceptions.ModelNotFoundException;
import com.gathera.gathera.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User createUser(UserDTO userDTO);

    User updateUser(Long id, UserDTO userDTO) throws ModelNotFoundException;

    void deleteUser(Long id) throws ModelNotFoundException;

    User getUserById(Long id) throws ModelNotFoundException;
}
