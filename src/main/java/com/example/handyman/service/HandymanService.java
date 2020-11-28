package com.example.handyman.service;

import com.example.handyman.entity.HandymanEntity;

import java.util.List;

public interface HandymanService {
    public HandymanEntity getHandymanById(Long id);
    List<HandymanEntity> getAllHandyman();
    HandymanEntity addHandyman(HandymanEntity handymanEntity);
}
