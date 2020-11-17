package com.example.handyman.controller;

import com.example.handyman.controller.dto.OrderDTO;
import com.example.handyman.controller.transformer.OrderTransformer;
import com.example.handyman.entity.OrderEntity;
import com.example.handyman.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OrderController {
    private OrderService orderService;
    private OrderTransformer orderTransformer;

    @GetMapping("/{id}")
    public OrderDTO getUserById(@PathVariable Long id) {
        OrderEntity entity = orderService.getOrderById(id);
        OrderDTO dto = orderTransformer.createDTO(entity);
        return dto;
    }
}
