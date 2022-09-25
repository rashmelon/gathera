package com.gathera.gathera.controllers;

import com.gathera.gathera.dtos.GroupDTO;
import com.gathera.gathera.models.Group;
import com.gathera.gathera.services.GroupService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("groups")
public class GroupController {

    private final GroupService groupService;

    GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public List<Group> index() {
        return groupService.getAllGroups();
    }

    @PostMapping
    public Group store(@Valid @RequestBody GroupDTO newGroup) {

        return groupService.createGroup(newGroup);
    }

    @GetMapping({ "/{id}"})
    public Group show(@PathVariable(name = "id") Long id) {

        return groupService.getGroupById(id);
    }

    @PutMapping({ "/{id}"})
    public Group update(@PathVariable(name = "id") Long id, @RequestBody GroupDTO newGroup) {

        return groupService.updateGroup(id, newGroup);
    }

    @DeleteMapping({ "/{id}"})
    public void delete(@PathVariable(name = "id") Long id) {

        groupService.deleteGroup(id);
    }
}
