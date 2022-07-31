package com.ironhack.edgeservice.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ironhack.edgeservice.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SnackOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateCreated;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private Long[] products_id;

    private Long userId;

    private Boolean isSubscription;

    public Double totalPrice;

    public Long shippingAddress;

}
