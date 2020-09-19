package com.example.handyman.controller.transformer;

import com.example.handyman.controller.dto.MessageDTO;
import com.example.handyman.entity.MessageEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MessageTransformer implements Transformer<MessageEntity, MessageDTO> {
    @Override
    public MessageEntity createEntity(MessageDTO dto) {
        MessageEntity entity = new MessageEntity();
        entity.setId(dto.getId());
        entity.setFromUserId(dto.getFromUserId());
        entity.setToUserId(dto.getToUserId());
        entity.setContent(dto.getContent());
        entity.setEdited(dto.isEdited());
        entity.setUpdateDate(dto.getUpdateDate());
        entity.setCreateDate(dto.getCreateDate());
        return entity;
    }

    @Override
    public MessageDTO createDTO(MessageEntity entity) {
        MessageDTO dto = new MessageDTO();
        dto.setId(entity.getId());
        dto.setFromUserId(entity.getFromUserId());
        dto.setToUserId(entity.getToUserId());
        dto.setContent(entity.getContent());
        dto.setEdited(entity.isEdited());
        dto.setUpdateDate(entity.getUpdateDate());
        dto.setCreateDate(entity.getCreateDate());
        return dto;
    }

    @Override
    public List<MessageDTO> createDTOList(List<MessageEntity> entityList) {
        return entityList.stream().map(this::createDTO).collect(Collectors.toList());
    }

    @Override
    public List<MessageEntity> createEntityList(List<MessageDTO> dtoList) {
        return dtoList.stream().map(this::createEntity).collect(Collectors.toList());
    }
}
