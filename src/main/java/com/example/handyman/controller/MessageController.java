package com.example.handyman.controller;

import com.example.handyman.controller.dto.BaseDTO;
import com.example.handyman.controller.dto.MessageDTO;
import com.example.handyman.controller.transformer.MessageTransformer;
import com.example.handyman.entity.BaseEntity;
import com.example.handyman.entity.MessageEntity;
import com.example.handyman.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    MessageService messageService;
    @Autowired
    MessageTransformer messageTransformer;

    @GetMapping("/{fromId}/{toId}")
    public List<MessageDTO> getMessageList(@PathVariable Long fromId, @PathVariable Long toId) {
        List<MessageEntity> messageListByFromIdAndToId = messageService.getMessageListByFromIdAndToId(fromId, toId);
        List<BaseEntity> baseEntities = messageListByFromIdAndToId.stream().map(e -> (BaseEntity) e).collect(Collectors.toList());
        List<BaseDTO> dtos = messageTransformer.createDTOList(baseEntities);
        return dtos.stream().map(m -> (MessageDTO) m).collect(Collectors.toList());
    }
}
