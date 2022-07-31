package com.ironhack.edgeservice.service.impl;

import com.ironhack.edgeservice.client.FridgeFillServiceClient;
import com.ironhack.edgeservice.model.FridgeFill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class FridgeFillService {

    @Autowired
    private FridgeFillServiceClient fridgeFillServiceClient;


    // ALL FRIDGE FILLS
    public List<FridgeFill> getAllFridgeFill(){
        try {
            return fridgeFillServiceClient.getAllFridgeFills();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }
    }

    //FRIDGE FILL BY ID
    public FridgeFill getFridgeFillById(Long id) {
        try {
            return fridgeFillServiceClient.getFridgeFillById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }

    }

    public void deleteFridgeFill(Long id) throws Exception {
        try {
            fridgeFillServiceClient.deleteFridgeFillId(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }
    }


    // UPDATE FRIDGE FILL
    public void updateFridgeFill(Long id, FridgeFill fridgeFill) throws Exception {
        try {
            fridgeFillServiceClient.updateFridgeFill(id, fridgeFill);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }

    }



    // CREATE FRIDGE FILL
    public void createNewFridgeFill(FridgeFill fridgeFill){
        try {
            fridgeFillServiceClient.createNewFridgeFill(fridgeFill);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }
    }


}
