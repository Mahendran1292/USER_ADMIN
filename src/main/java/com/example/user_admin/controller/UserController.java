package com.example.user_admin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.user_admin.dto.ApiResponse;
import com.example.user_admin.dto.UpdateUserDto;
import com.example.user_admin.model.User;
import com.example.user_admin.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/me")
    public ResponseEntity<ApiResponse> getMe() {
        String userId = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.getUserById(userId).orElse(null);

        if (user != null) {
            return ResponseEntity.ok(new ApiResponse("User retrieved successfully", user));
        } else {
            return ResponseEntity.status(404).body(new ApiResponse("User not found", null));
        }
    }

    @PutMapping("/user/me")
    public ResponseEntity<ApiResponse> updateMe(@RequestBody UpdateUserDto updateUserDto) {
        String userId = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User updatedUser = userService.updateUser(userId, updateUserDto);

        if (updatedUser != null) {
            return ResponseEntity.ok(new ApiResponse("User updated successfully", updatedUser));
        } else {
            return ResponseEntity.status(404).body(new ApiResponse("User not found", null));
        }
    }
}




















