package com.gathera.gathera.services;

import com.gathera.gathera.dtos.GroupDTO;
import com.gathera.gathera.exceptions.ModelNotFoundException;
import com.gathera.gathera.models.Group;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroups();

    Group createGroup(GroupDTO groupDTO);

    Group updateGroup(Long id, GroupDTO groupDTO) throws ModelNotFoundException;

    void deleteGroup(Long id) throws ModelNotFoundException;

    Group getGroupById(Long id) throws ModelNotFoundException;
}
