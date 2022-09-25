package com.gathera.gathera.dtos;

import com.gathera.gathera.models.User;
import lombok.Data;

@Data
public class UserDTO implements DTO<User>{
    private String name;

    private String email;

    private String password;

    private String phone;

    @Override
    public void fillModel(User user) {
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
    }
}
