package com.example.handyman.controller.dto;

import com.example.handyman.entity.enums.OrderResult;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO extends BaseDTO {
    private UserDTO customer;
    private UserDTO handymen;
    private BigDecimal price;
    private String description;
    private Date startDate;
    private Date finishDate;
    private OrderResult result;
}
