package com.ironhack.edgeservice.controller.impl;


import com.ironhack.edgeservice.model.SnackOrder;
import com.ironhack.edgeservice.service.impl.SnackOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(value = "http://localhost:4200")
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
        return snackOrderService.getSnackOrderById(id);
    }

    @GetMapping("/snacks-orders/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<SnackOrder> getSnackOrderByUserId(@PathVariable Long userId) {
        return snackOrderService.getSnackOrderByUserId(userId);

    }


    @PutMapping("/snacks-orders/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateSnackOrder(@PathVariable Long id,  @RequestBody SnackOrder snackOrder) throws Exception {
        snackOrderService.updateSnackOrder(id, snackOrder);

    }

    @PostMapping("/snack-orders")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewSnackOrder(@RequestBody SnackOrder snackOrder){
        snackOrderService.createNewSnackOrder(snackOrder);
    }



}
