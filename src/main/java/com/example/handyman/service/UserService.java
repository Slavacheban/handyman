package com.example.handyman.service;

import com.example.handyman.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserEntity getUserById(Long id);
    Optional<UserEntity> getUserByLogin(String login);
    List<UserEntity> getAll();
}
