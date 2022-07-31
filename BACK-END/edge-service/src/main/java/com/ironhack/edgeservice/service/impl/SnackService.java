package com.ironhack.edgeservice.service.impl;

import com.ironhack.edgeservice.client.SnackServiceClient;
import com.ironhack.edgeservice.model.Snack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SnackService {

    @Autowired
    private SnackServiceClient snackServiceClient;

    // ALL SNACKS
    public List<Snack> getAllSnacks(){
        try {
            return snackServiceClient.getAllSnacks();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }

    }

    //SNACK BY ID
    public Snack getSnackById(Long id) {
        try {
            return snackServiceClient.getSnackById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }

    }

    // DELETE SNACK
    public void deleteSnack(Long id) throws Exception {
        try {
            snackServiceClient.deleteSnackId(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }
    }

    // UPDATE SNACK
    public void updateSnack(Long id, Snack snack) throws Exception {
        try {
            snackServiceClient.updateSnack(id, snack);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }
    }


    // CREATE SNACK
    public void createNewSnack(Snack snack){
        try {
            snackServiceClient.createNewSnack(snack);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }

    }
}
