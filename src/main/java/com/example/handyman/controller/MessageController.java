package com.example.handyman.controller;

import com.example.handyman.controller.dto.MessageDTO;
import com.example.handyman.controller.transformer.MessageTransformer;
import com.example.handyman.entity.MessageEntity;
import com.example.handyman.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MessageController {
    private MessageService messageService;
    private MessageTransformer messageTransformer;

    @GetMapping("/{fromId}/{toId}")
    public List<MessageDTO> getMessageList(@PathVariable Long fromId, @PathVariable Long toId) {
        List<MessageEntity> messageListByFromIdAndToId = messageService.getMessageListByFromIdAndToId(fromId, toId);
        return messageTransformer.createDTOList(messageListByFromIdAndToId);
    }
}
