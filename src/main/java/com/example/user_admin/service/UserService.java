package com.example.user_admin.service;

import java.util.List;
import java.util.Optional;

import com.example.user_admin.dto.UpdateUserDto;
import com.example.user_admin.dto.UserDto;
import com.example.user_admin.model.User;

public interface UserService {
    User createUser(UserDto userDto);
    List<User> getAllUsers();
    Optional<User> getUserById(String id);
    User updateUser(String id, UpdateUserDto updateUserDto);
    void deleteUser(String id);
    User login(String phone, String role);
}
















