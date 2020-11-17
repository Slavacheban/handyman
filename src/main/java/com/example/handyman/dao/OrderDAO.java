package com.example.handyman.dao;

import com.example.handyman.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<OrderEntity, Long> {
}
