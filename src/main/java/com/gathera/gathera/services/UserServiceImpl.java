package com.gathera.gathera.services;

import com.gathera.gathera.dtos.UserDTO;
import com.gathera.gathera.exceptions.ModelNotFoundException;
import com.gathera.gathera.models.User;
import com.gathera.gathera.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User createUser(UserDTO userDTO) {
        User user = new User();
        userDTO.fillModel(user);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(ModelNotFoundException::new);
        userDTO.fillModel(user);
        user.setUpdatedAt(LocalDateTime.now());

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(ModelNotFoundException::new);

        userRepository.delete(user);
    }

    @Override
    public User getUserById(Long id) throws ModelNotFoundException {
        Optional<User> result = userRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new ModelNotFoundException();
        }
    }
}
