package com.example.handyman.controller;

import com.example.handyman.controller.dto.OrderDTO;
import com.example.handyman.controller.transformer.OrderTransformer;
import com.example.handyman.entity.OrderEntity;
import com.example.handyman.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://192.168.0.102:4201", maxAge = 3600)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OrderController {
    private OrderService orderService;
    private OrderTransformer orderTransformer;

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('orders:read')")
    public OrderDTO getUserById(@PathVariable Long id) {
        OrderEntity entity = orderService.getOrderById(id);
        return orderTransformer.createDTO(entity);
    }
}
