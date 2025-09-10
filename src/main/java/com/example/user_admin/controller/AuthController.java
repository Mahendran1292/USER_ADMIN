package com.example.user_admin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.user_admin.dto.ApiResponse;
import com.example.user_admin.dto.LoginRequest;
import com.example.user_admin.dto.LoginResponse;
import com.example.user_admin.dto.UserDto;
import com.example.user_admin.model.User;
import com.example.user_admin.security.JwtUtil;
import com.example.user_admin.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/user/register")
    public ResponseEntity<ApiResponse> register(@RequestBody UserDto userDto) {
        User existingUser = userService.login(userDto.getPhone(), userDto.getRole());
        if (existingUser != null) {
            return ResponseEntity.badRequest()
                    .body(new ApiResponse("User already exists with this phone and role", null));
        }

        User newUser = userService.createUser(userDto);
        return ResponseEntity.ok(new ApiResponse("User registered successfully", newUser));
    }

    @PostMapping("/user/login")
    public ResponseEntity<ApiResponse> login(@RequestBody LoginRequest request) {
        User user = userService.login(request.getPhone(), request.getRole());

        if (user == null) {
            return ResponseEntity.status(401)
                    .body(new ApiResponse("Invalid phone number or role", null));
        }

        String token = jwtUtil.generateToken(user.getId(), user.getRole());
        LoginResponse response = new LoginResponse(token, user.getId(), user.getPhone(), user.getRole());

        return ResponseEntity.ok(new ApiResponse("Login successful", response));
    }
}















