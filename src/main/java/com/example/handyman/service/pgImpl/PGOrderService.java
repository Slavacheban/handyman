package com.example.handyman.service.pgImpl;

import com.example.handyman.dao.OrderDAO;
import com.example.handyman.entity.OrderEntity;
import com.example.handyman.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PGOrderService implements OrderService {
    private OrderDAO orderDAO;

    @Override
    public OrderEntity getOrderById(Long id) {
        return orderDAO.getOne(id);
    }

    @Override
    public OrderEntity createOrder(OrderEntity orderEntity) {
        return orderDAO.save(orderEntity);
    }

    @Override
    public void deleteOrderById(Long id) {
        orderDAO.deleteById(id);
    }
}
