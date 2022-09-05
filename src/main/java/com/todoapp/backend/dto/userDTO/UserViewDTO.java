package com.todoapp.backend.dto.userDTO;

import com.todoapp.backend.entity.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public final class UserViewDTO implements Serializable {

    private final Long Id;

    private final String firstName;

    private final String lastName;

    private final boolean checked;

    public UserViewDTO(Long id, String firstName, String lastName, boolean checked) {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.checked = checked;
    }


    public static UserViewDTO of(User user){
        return new UserViewDTO(user.getId(), user.getFirstName(), user.getLastName(), user.isChecked());
    }
}
