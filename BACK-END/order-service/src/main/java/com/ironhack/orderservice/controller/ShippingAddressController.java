package com.ironhack.orderservice.controller;


import com.ironhack.orderservice.model.ShippingAddress;
import com.ironhack.orderservice.service.ShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ShippingAddressController {

    @Autowired
    ShippingAddressService shippingAddressService;


    @GetMapping("/shipping-address/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ShippingAddress getShippingAddressById(@PathVariable Long id) throws Exception {
        Optional<ShippingAddress> maybeShippingAddress = shippingAddressService.getShippingAddressById(id);
        if(maybeShippingAddress.isEmpty()){
            throw new Exception("No shipping address found");
        }
        return new ShippingAddress(
                maybeShippingAddress.get().getId(),
        maybeShippingAddress.get().getName(),
        maybeShippingAddress.get().getStreet(),
        maybeShippingAddress.get().getStreetDetails(),
        maybeShippingAddress.get().getCity(),
        maybeShippingAddress.get().getState(),
        maybeShippingAddress.get().getZipCode(),
        maybeShippingAddress.get().getPhone(),
        maybeShippingAddress.get().getUserId());


    }

    @GetMapping("/shipping-address/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ShippingAddress> getShippingAddressByUserId(@PathVariable Long userId) {
        return shippingAddressService.getShippingAddressByUserId(userId);

    }


    @PutMapping("/shipping-address/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateShippingAddress(@PathVariable Long id,  @RequestBody ShippingAddress shippingAddress) throws Exception {
        ShippingAddress updateShippingAddress = new ShippingAddress(
                shippingAddress.getId(),
                shippingAddress.getName(),
                shippingAddress.getStreet(),
                shippingAddress.getStreetDetails(),
                shippingAddress.getCity(),
                shippingAddress.getState(),
                shippingAddress.getZipCode(),
                shippingAddress.getPhone(),
                shippingAddress.getUserId());
        shippingAddressService.updateShippingAddress(id, updateShippingAddress);

    }

    @PostMapping("/shipping-address")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewShippingAddress(@RequestBody ShippingAddress shippingAddress){
        ShippingAddress newShippingAddress = new ShippingAddress(
                shippingAddress.getId(),
                shippingAddress.getName(),
                shippingAddress.getStreet(),
                shippingAddress.getStreetDetails(),
                shippingAddress.getCity(),
                shippingAddress.getState(),
                shippingAddress.getZipCode(),
                shippingAddress.getPhone(),
                shippingAddress.getUserId());
        shippingAddressService.createNewShippingAddress(newShippingAddress);
    }



}
