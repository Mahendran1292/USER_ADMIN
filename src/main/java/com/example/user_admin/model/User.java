package com.example.user_admin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "users")
public class User {
    
    @Id
    private String id;

    @NotBlank
    private String name;
    
    @NotBlank
    @Indexed(unique=true)
    private String phone;
   
    @NotBlank
    private String dob;
   
    @NotBlank
    private String role;
   
    @NotBlank 
    @Indexed(unique=true)      
    private String profilePic;
}


















