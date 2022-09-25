package com.gathera.gathera.repositories;

import com.gathera.gathera.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
