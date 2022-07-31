package com.ironhack.edgeservice.service.impl;

import com.ironhack.edgeservice.client.SnackOrderServiceClient;
import com.ironhack.edgeservice.model.ShippingAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ShippingAddressService {

    @Autowired
    SnackOrderServiceClient snackOrderServiceClient;
//
//    public List<ShippingAddress> getAllShippingAddress(){
//        try {
//            return shippingAddressServiceClient.ge();
//        } catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
//        }
//
//    }

    public ShippingAddress getShippingAddressById(Long id) {
        try{
            return snackOrderServiceClient.getShippingAddressById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }

    }
    public List<ShippingAddress> getShippingAddressByUserId(Long userId){
        try{
            return snackOrderServiceClient.getShippingAddressByUserId(userId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }
    }

    public void updateShippingAddress(Long id, ShippingAddress shippingAddress) throws Exception {
        try{
            snackOrderServiceClient.updateShippingAddress(id, shippingAddress);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }

    }

    public void createNewShippingAddress(ShippingAddress shippingAddress){
        try{
            snackOrderServiceClient.createNewShippingAddress(shippingAddress);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }

    }



}
