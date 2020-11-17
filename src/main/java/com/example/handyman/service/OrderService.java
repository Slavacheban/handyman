package com.example.handyman.service;

import com.example.handyman.entity.OrderEntity;

public interface OrderService {
    OrderEntity getOrderById(Long id);
    OrderEntity createOrder(OrderEntity orderEntity);
    void deleteOrderById(Long id);
}
