package com.ironhack.orderservice.controller;


import com.ironhack.orderservice.model.SnackOrder;
import com.ironhack.orderservice.service.SnackOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SnackOrderController {

    @Autowired
    SnackOrderService snackOrderService;

    @GetMapping("/snacks-orders")
    @ResponseStatus(HttpStatus.OK)
    public List<SnackOrder> getAllSnackOrder(){
        return snackOrderService.getAllSnackOrder();
    }

    @GetMapping("/snacks-orders/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SnackOrder getSnackOrderById(@PathVariable Long id) throws Exception {
        Optional<SnackOrder> maybeSnackOrder = snackOrderService.getSnackOrderById(id);
        if(maybeSnackOrder.isEmpty()){
            throw new Exception("No order found");
        }
        return new SnackOrder(
                maybeSnackOrder.get().getId(),
                maybeSnackOrder.get().getDateCreated(),
        maybeSnackOrder.get().getOrderStatus(),
        maybeSnackOrder.get().getProducts_id(),
        maybeSnackOrder.get().getUserId(),
        maybeSnackOrder.get().getIsSubscription(),
        maybeSnackOrder.get().getTotalPrice(),
        maybeSnackOrder.get().getShippingAddress());
    }

    @GetMapping("/snacks-orders/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<SnackOrder> getSnackOrderByUserId(@PathVariable Long userId) {
        return snackOrderService.getSnackOrderByUserId(userId);

    }


    @PutMapping("/snacks-orders/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateSnackOrder(@PathVariable Long id,  @RequestBody SnackOrder snackOrder) throws Exception {
        SnackOrder updateSnackOrder = new SnackOrder(

                snackOrder.getId(),
                snackOrder.getDateCreated(),
                snackOrder.getOrderStatus(),
                snackOrder.getProducts_id(),
                snackOrder.getUserId(),
                snackOrder.getIsSubscription(),
                snackOrder.getTotalPrice(),
                snackOrder.getShippingAddress());
        snackOrderService.updateSnackOrder(id, updateSnackOrder);

    }

    @PostMapping("/snack-orders")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewSnackOrder(@RequestBody SnackOrder snackOrder){
        SnackOrder newSnackOrder = new SnackOrder(
                snackOrder.getId(),
                snackOrder.getDateCreated(),
                snackOrder.getOrderStatus(),
                snackOrder.getProducts_id(),
                snackOrder.getUserId(),
                snackOrder.getIsSubscription(),
                snackOrder.getTotalPrice(),
                snackOrder.getShippingAddress());
        snackOrderService.createNewSnackOrder(snackOrder);
    }



}
