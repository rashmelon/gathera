package com.gathera.gathera.services;

import com.gathera.gathera.dtos.GroupDTO;
import com.gathera.gathera.exceptions.ModelNotFoundException;
import com.gathera.gathera.models.Group;
import com.gathera.gathera.models.User;
import com.gathera.gathera.repositories.GroupRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService{

    private final GroupRepository groupRepository;

    private final UserService userService;

    public GroupServiceImpl(GroupRepository groupRepository, UserService userService) {
        super();
        this.groupRepository = groupRepository;
        this.userService = userService;
    }

    @Override
    public List<Group> getAllGroups() {
        return (List<Group>) groupRepository.findAll();
    }

    @Override
    public Group createGroup(GroupDTO groupDTO) {
        Group group = new Group();
        groupDTO.fillModel(group);
        group.setCreatedAt(LocalDateTime.now());
        group.setUpdatedAt(LocalDateTime.now());
        User user = userService.getUserById(groupDTO.getOwnerId());
        group.setOwner(user);

        return groupRepository.save(group);
    }

    @Override
    public Group updateGroup(Long id, GroupDTO groupDTO) {
        Group group = groupRepository.findById(id)
                .orElseThrow(ModelNotFoundException::new);
        groupDTO.fillModel(group);
        group.setUpdatedAt(LocalDateTime.now());
        User user = userService.getUserById(groupDTO.getOwnerId());
        group.setOwner(user);


        return groupRepository.save(group);
    }

    @Override
    public void deleteGroup(Long id) {
        Group group = groupRepository.findById(id)
                .orElseThrow(ModelNotFoundException::new);

        groupRepository.delete(group);
    }

    @Override
    public Group getGroupById(Long id) throws ModelNotFoundException {
        Optional<Group> result = groupRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new ModelNotFoundException();
        }
    }
}
