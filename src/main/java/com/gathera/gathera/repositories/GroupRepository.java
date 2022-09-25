package com.gathera.gathera.repositories;

import com.gathera.gathera.models.Group;
import com.gathera.gathera.models.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<Group, Long> {
}
