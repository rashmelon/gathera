package com.gathera.gathera.dtos;

import com.gathera.gathera.models.Group;
import com.gathera.gathera.models.User;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Data
public class GroupDTO implements DTO<Group>{
    private Long ownerId;

    private String name;

    public void fillModel(Group group) {
        group.setName(name);
    }
}
