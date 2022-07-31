package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.model.ShippingAddress;
import com.ironhack.edgeservice.model.SnackOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@FeignClient("order-service")
public interface SnackOrderServiceClient {


    @GetMapping("/snacks-orders")
    public List<SnackOrder> getAllSnackOrder();

    @GetMapping("/snacks-orders/{id}")
    public SnackOrder getSnackOrderById(@PathVariable Long id) throws Exception;

    @GetMapping("/snacks-orders/{userId}")
    public List<SnackOrder> getSnackOrderByUserId(@PathVariable Long userId) ;

    @PutMapping("/snacks-orders/{id}")
    public void updateSnackOrder(@PathVariable Long id,  @RequestBody SnackOrder snackOrder) throws Exception;

    @PostMapping("/snack-orders")
    public void createNewSnackOrder(@RequestBody SnackOrder snackOrder);



/////////////////////////////
    @GetMapping("/shipping-address/{id}")
    public ShippingAddress getShippingAddressById(@PathVariable Long id) throws Exception ;

    @GetMapping("/shipping-address/{userId}")
    public List<ShippingAddress> getShippingAddressByUserId(@PathVariable Long userId) ;

    @PutMapping("/shipping-address/{id}")
    public void updateShippingAddress(@PathVariable Long id,  @RequestBody ShippingAddress shippingAddress) throws Exception ;

    @PostMapping("/shipping-address")
    public void createNewShippingAddress(@RequestBody ShippingAddress shippingAddress);
}
