package com.todoapp.backend.dto.userDTO;

import lombok.Data;

@Data
public class UserCreateDTO {


    private String firstName;

    private String lastName;

    private boolean checked = false;

}
