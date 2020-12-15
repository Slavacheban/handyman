package com.example.handyman.controller;

import com.example.handyman.controller.dto.OrderDTO;
import com.example.handyman.controller.transformer.OrderTransformer;
import com.example.handyman.entity.OrderEntity;
import com.example.handyman.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
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

    @GetMapping
    public List<OrderDTO> getOrderList() {
        List<OrderEntity> orderEntityList = orderService.getAllOrders();
        return orderTransformer.createDTOList(orderEntityList);
    }
}
