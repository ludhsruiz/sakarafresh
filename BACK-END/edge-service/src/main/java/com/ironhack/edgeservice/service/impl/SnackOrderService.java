package com.ironhack.edgeservice.service.impl;


import com.ironhack.edgeservice.client.SnackOrderServiceClient;
import com.ironhack.edgeservice.model.SnackOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SnackOrderService {

    @Autowired
    SnackOrderServiceClient snackOrderServiceClient;


    public List<SnackOrder> getAllSnackOrder(){
        try {
            return snackOrderServiceClient.getAllSnackOrder();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }

    }


    public SnackOrder getSnackOrderById(Long id) {
        try{
            return snackOrderServiceClient.getSnackOrderById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }

    }

    public List<SnackOrder> getSnackOrderByUserId(Long userId){
        try{
            return snackOrderServiceClient.getSnackOrderByUserId(userId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }
    }

    public void updateSnackOrder(Long id, SnackOrder snackOrder) throws Exception {
        try{
            snackOrderServiceClient.updateSnackOrder(id, snackOrder);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }

    }

    public void createNewSnackOrder(SnackOrder snackOrder){
        try{
            snackOrderServiceClient.createNewSnackOrder(snackOrder);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }

    }

}
