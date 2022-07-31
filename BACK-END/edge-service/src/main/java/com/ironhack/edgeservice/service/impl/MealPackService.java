package com.ironhack.edgeservice.service.impl;

import com.ironhack.edgeservice.client.MealPackServiceClient;
import com.ironhack.edgeservice.model.MealPack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MealPackService {

    @Autowired
    private MealPackServiceClient mealPackServiceClient;

    // ALL MEAL PACKS
    public List<MealPack> getAllMealPack() {
        try {
            return mealPackServiceClient.getAllMealPack();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }

    }

    // MEAL PACK BY ID
    public MealPack getMealPackById(Long id) {
        try {
            return mealPackServiceClient.getMealPackById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }

    }


    // DELETE PACK
    public void deleteMealPack(Long id) throws Exception {
        try {
            mealPackServiceClient.deleteMealPack(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }
    }

    // UPDATE MEALPACK
    public void updateMealPack(Long id, MealPack mealPack) throws Exception {
        try {
            mealPackServiceClient.updateMealPack(id, mealPack);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }
   }


    // CREATE MEAL PACK
    public void createNewMealPack(MealPack mealPack){
        try {
            mealPackServiceClient.createNewMealPack(mealPack);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }

    }
}
