package com.example.handyman.controller.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageDTO extends BaseDTO {
    private UserDTO fromUser;
    private UserDTO toUser;
    private boolean isEdited;
    private String content;
}
