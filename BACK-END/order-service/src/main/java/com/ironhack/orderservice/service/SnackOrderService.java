package com.ironhack.orderservice.service;


import com.ironhack.orderservice.model.SnackOrder;
import com.ironhack.orderservice.repository.SnackOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SnackOrderService {

    @Autowired
    SnackOrderRepository snackOrderRepository;


    public List<SnackOrder> getAllSnackOrder(){
        return snackOrderRepository.findAll();
    }


    public Optional<SnackOrder> getSnackOrderById(Long id) {
        return snackOrderRepository.findById(id);

    }

    public List<SnackOrder> getSnackOrderByUserId(Long userId){
        return snackOrderRepository.getSnackOrderByUserId(userId);
    }

    public void updateSnackOrder(Long id, SnackOrder snackOrder) throws Exception {
        Optional<SnackOrder> maybeSnackOrder= snackOrderRepository.findById(id);
        if(maybeSnackOrder.isEmpty()){
            throw new Exception("No order found");
        }
        maybeSnackOrder.get().setId(snackOrder.getId());
        maybeSnackOrder.get().setDateCreated(snackOrder.getDateCreated());
        maybeSnackOrder.get().setOrderStatus(snackOrder.getOrderStatus());
        maybeSnackOrder.get().setProducts_id(snackOrder.getProducts_id());
        maybeSnackOrder.get().setUserId(snackOrder.getUserId());
        maybeSnackOrder.get().setIsSubscription(snackOrder.getIsSubscription());
        maybeSnackOrder.get().setTotalPrice(snackOrder.getTotalPrice());
        maybeSnackOrder.get().setShippingAddress(snackOrder.getShippingAddress());
        snackOrderRepository.save(maybeSnackOrder.get());

    }

    public void createNewSnackOrder(SnackOrder snackOrder){
        snackOrderRepository.save(snackOrder);
    }

}
