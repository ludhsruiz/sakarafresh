package com.ironhack.edgeservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShippingAddress {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String street;
    private String streetDetails;
    private String city;
    private String state;
    private int zipCode;
    private int phone;

    private Long userId;


}
