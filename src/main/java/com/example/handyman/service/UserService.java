package com.example.handyman.service;

import com.example.handyman.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity getUserById(Long id);

    List<UserEntity> getAll();
}
