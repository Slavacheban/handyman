package com.example.handyman.controller.dto;


import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class MessageDTO extends BaseDTO {
    private Long fromUserId;
    private Long toUserId;
    private boolean isEdited;
    private String content;
}
