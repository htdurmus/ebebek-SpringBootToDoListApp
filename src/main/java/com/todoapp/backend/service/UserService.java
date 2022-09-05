package com.todoapp.backend.service;

import com.todoapp.backend.dto.userDTO.UserCreateDTO;
import com.todoapp.backend.dto.userDTO.UserUpdateDTO;
import com.todoapp.backend.dto.userDTO.UserViewDTO;

import java.util.List;

public interface UserService {

    UserViewDTO getListById(long id);

    List<UserViewDTO> getLists();

    UserViewDTO createUser(UserCreateDTO userCreateDTO);

    UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO);

    void deleteUser(Long id);
}
