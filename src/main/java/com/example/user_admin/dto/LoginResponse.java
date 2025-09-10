package com.example.user_admin.dto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String token; 
    private String id;
    private String phone;
    private String role;
}


