package com.todoapp.backend.service;

import com.todoapp.backend.dto.userDTO.UserCreateDTO;
import com.todoapp.backend.dto.userDTO.UserUpdateDTO;
import com.todoapp.backend.dto.userDTO.UserViewDTO;
import com.todoapp.backend.entity.User;
import com.todoapp.backend.exception.NotFoundSayfasi;
import com.todoapp.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserViewDTO getListById(long id) {
        final User user = userRepository.findById(id).orElseThrow(() -> new NotFoundSayfasi("hata mesajı"));
        return UserViewDTO.of(user);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<UserViewDTO> getLists() {
        return userRepository.findAll().stream().map(UserViewDTO::of).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserViewDTO createUser(UserCreateDTO userCreateDTO) {
        final User user = userRepository.save(new User(userCreateDTO.getFirstName(), userCreateDTO.getLastName(), userCreateDTO.isChecked()));
        return UserViewDTO.of(user);
    }

    @Override
    @Transactional
    public UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO) {
        final User user = userRepository.findById(id).orElseThrow(() -> new NotFoundSayfasi("Hata!"));

        user.setFirstName(userUpdateDTO.getFirstName());
        user.setLastName(userUpdateDTO.getLastName());
        user.setChecked(userUpdateDTO.isChecked());

        final User updatedUser = userRepository.save(user);

        return UserViewDTO.of(updatedUser);
    }

    @Override
    @Transactional
    public void deleteUser(Long id){
        final User user = userRepository.findById(id).orElseThrow(() -> new NotFoundSayfasi("Kullanıcı bulunamadı !"));
        userRepository.deleteById(user.getId());
    }
}
