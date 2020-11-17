package com.example.handyman.controller.dto;

import lombok.Data;

import java.util.Date;

@Data
public abstract class BaseDTO {
    Long id;
    Date updateDate;
    Date createDate;
}
