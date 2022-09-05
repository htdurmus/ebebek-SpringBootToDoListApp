package com.todoapp.backend.dto.userDTO;

import lombok.Data;

@Data
public class UserUpdateDTO {

    private String firstName;

    private String lastName;

    private boolean checked;

}
