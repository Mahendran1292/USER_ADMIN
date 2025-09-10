package com.example.user_admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.user_admin.dto.UpdateUserDto;
import com.example.user_admin.dto.UserDto;
import com.example.user_admin.model.User;
import com.example.user_admin.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setPhone(userDto.getPhone());
        user.setDob(userDto.getDob());
        user.setRole(userDto.getRole());
        user.setProfilePic(userDto.getProfilePic());
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
public User updateUser(String id, UpdateUserDto updateUserDto) {
    Optional<User> optUser = userRepository.findById(id);
    if (optUser.isPresent()) {
        User user = optUser.get();

        if (updateUserDto.getName() != null) {
            user.setName(updateUserDto.getName());
        }
        if (updateUserDto.getDob() != null) {
            user.setDob(updateUserDto.getDob());
        }
        if (updateUserDto.getRole() != null) {
            user.setRole(updateUserDto.getRole());
        }
        if (updateUserDto.getProfilePic() != null) {
            user.setProfilePic(updateUserDto.getProfilePic());
        }
        if (updateUserDto.getPhone() != null) {
            user.setPhone(updateUserDto.getPhone());
        }

        return userRepository.save(user);
    } else {
        return null; 
    }
   } 

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public User login(String phone, String role) {
        return userRepository.findByPhoneAndRole(phone, role).orElse(null);
    }
}




















