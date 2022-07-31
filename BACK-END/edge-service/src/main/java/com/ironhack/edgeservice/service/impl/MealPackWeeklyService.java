package com.ironhack.edgeservice.service.impl;


import com.ironhack.edgeservice.client.MealPackServiceClient;
import com.ironhack.edgeservice.model.MealPackWeekly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MealPackWeeklyService {

    @Autowired
    private MealPackServiceClient mealPackServiceClient;



    // ALL MEAL PACKS WEEKLY
    public List<MealPackWeekly> getAllMealPackWeekly(){
        try {
            return mealPackServiceClient.getAllMealPackWeekly();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }
    }


    // MEAL PACK BY ID
    public MealPackWeekly getMealPackWeeklyById(Long id) {
        try {
            return mealPackServiceClient.getMealPackWeeklyById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }

    }


    // DELETE PACK
    public void deleteMealPackWeekly(Long id) throws Exception {
        try {
            mealPackServiceClient.deleteMealPackWeekly(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }
    }

    // UPDATE MEALPACK WEEKLY
    public void updateMealPackWeekly(Long id, MealPackWeekly mealPackDaily) throws Exception {
        try {
            mealPackServiceClient.updateMealPackWeekly(id, mealPackDaily);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }
    }


    // CREATE MEAL PACK
    public void createNewMealPackWeekly(MealPackWeekly mealPackWeekly){
        try {
            mealPackServiceClient.createNewMealPackWeekly(mealPackWeekly);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }
    }
}
