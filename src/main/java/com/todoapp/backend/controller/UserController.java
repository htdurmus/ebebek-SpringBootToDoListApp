package com.todoapp.backend.controller;

import com.todoapp.backend.dto.userDTO.UserCreateDTO;
import com.todoapp.backend.dto.userDTO.UserUpdateDTO;
import com.todoapp.backend.dto.userDTO.UserViewDTO;
import com.todoapp.backend.service.UserService;
import com.todoapp.backend.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping(path = "/list={id}")
    public ResponseEntity<UserViewDTO> getListById(@PathVariable Long id){
        final UserViewDTO user = userService.getListById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<UserViewDTO>> getUsers(){
        final List<UserViewDTO> lists = userService.getLists();
        return ResponseEntity.ok(lists);
    }

    @PostMapping(path = "/newUser")
    public ResponseEntity<?> createUser(@RequestBody UserCreateDTO userCreateDTO){
        userService.createUser(userCreateDTO);
        return ResponseEntity.ok(new GenericResponse("Kullanıcı kaydedildi"));
    }

    @PutMapping(path = "/updateUser={id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody UserUpdateDTO userUpdateDTO){
        final UserViewDTO user = userService.updateUser(id,userUpdateDTO);
        return ResponseEntity.ok(new GenericResponse(id.toString()+" numaralı kullanıcı güncellendi"));
    }

    @DeleteMapping(path = "/deleteUser={id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok(new GenericResponse(id.toString()+" numaralı kullanıcı silindi"));
    }

}
