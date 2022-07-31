package com.ironhack.edgeservice.controller.impl;


import com.ironhack.edgeservice.model.ShippingAddress;
import com.ironhack.edgeservice.service.impl.ShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(value = "http://localhost:4200")
public class ShippingAddressController {

    @Autowired
    ShippingAddressService shippingAddressService;


    @GetMapping("/shipping-address/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ShippingAddress getShippingAddressById(@PathVariable Long id) throws Exception {

        return shippingAddressService.getShippingAddressById(id);


    }

    @GetMapping("/shipping-address/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ShippingAddress> getShippingAddressByUserId(@PathVariable Long userId) {
        return shippingAddressService.getShippingAddressByUserId(userId);

    }


    @PutMapping("/shipping-address/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateShippingAddress(@PathVariable Long id,  @RequestBody ShippingAddress shippingAddress) throws Exception {

        shippingAddressService.updateShippingAddress(id, shippingAddress);

    }

    @PostMapping("/shipping-address")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewShippingAddress(@RequestBody ShippingAddress shippingAddress){

        shippingAddressService.createNewShippingAddress(shippingAddress);
    }



}
