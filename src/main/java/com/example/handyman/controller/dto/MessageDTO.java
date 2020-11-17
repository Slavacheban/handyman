package com.example.handyman.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO extends BaseDTO {
    private UserDTO fromUser;
    private UserDTO toUser;
    private boolean isEdited;
    private String content;
}
