package com.example.handyman.controller.transformer;

import com.example.handyman.controller.dto.OrderDTO;
import com.example.handyman.entity.OrderEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OrderTransformer extends Transformer<OrderEntity, OrderDTO> {
    private UserTransformer userTransformer;

    @Override

    public OrderDTO createDTO(OrderEntity entity) {
        OrderDTO dto = new OrderDTO();
//        dto.setCustomer(userTransformer.createDTO(entity.getCustomer()));
        dto.setDescription(entity.getDescription());
        dto.setStartDate(entity.getStartDate());
        dto.setFinishDate(entity.getFinishDate());
//        dto.setHandymen(userTransformer.createDTO(entity.getHandymen()));
        dto.setDescription(entity.getDescription());
        dto.setPrice(entity.getPrice());
        dto.setResult(entity.getResult());
        return dto;
    }

    @Override
    public OrderEntity createEntity(OrderDTO dto) {
        OrderEntity entity = new OrderEntity();
//        entity.setCustomer(userTransformer.createEntity(dto.getCustomer()));
        entity.setDescription(dto.getDescription());
        entity.setStartDate(dto.getStartDate());
        entity.setFinishDate(dto.getFinishDate());
//        entity.setHandymen(userTransformer.createEntity(dto.getHandymen()));
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setResult(dto.getResult());
        return entity;
    }
}
