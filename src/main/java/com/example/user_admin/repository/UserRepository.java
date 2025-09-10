package com.example.user_admin.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.user_admin.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByPhoneAndRole(String phone, String role);
}













