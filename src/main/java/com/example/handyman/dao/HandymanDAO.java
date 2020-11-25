package com.example.handyman.dao;

import com.example.handyman.entity.HandymanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface HandymanDAO extends JpaRepository<HandymanEntity, Long> {
    List<HandymanEntity> getAllByCreateDateBefore(Date date);
}
