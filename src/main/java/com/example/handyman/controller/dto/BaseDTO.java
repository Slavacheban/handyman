package com.example.handyman.controller.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public abstract class BaseDTO {
    Long id;
    Date updateDate;
    Date createDate;
}
