package com.example.handyman.entity;


import com.example.handyman.entity.enums.OrderResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order")
public class OrderEntity extends BaseEntity {

//    @ManyToOne
//    private UserEntity customer;
//    @ManyToOne
//    private UserEntity handymen;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "description")
    private String description;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "finish_date")
    private Date finishDate;
    @Column(name = "result")
    @Enumerated(EnumType.STRING)
    private OrderResult result;
}
