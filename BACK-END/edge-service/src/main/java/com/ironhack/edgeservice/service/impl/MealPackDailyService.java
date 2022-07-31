package com.ironhack.edgeservice.service.impl;

import com.ironhack.edgeservice.client.MealPackServiceClient;
import com.ironhack.edgeservice.model.MealPackDaily;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MealPackDailyService {

    @Autowired
    private MealPackServiceClient mealPackServiceClient;

    // ALL MEALPACKS
    public List<MealPackDaily> getAllMealPackDaily(){
        try {
            return mealPackServiceClient.getAllMealPackDaily();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }
    }


    // MEAL PACK BY ID
    public MealPackDaily getMealPackDailyById(Long id) {
        try {
            return mealPackServiceClient.getMealPackDailyById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }

    }


    // DELETE PACK
    public void deleteMealPackDaily(Long id) throws Exception {
        try {
            mealPackServiceClient.deleteMealPackDaily(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }
    }

    // UPDATE MEAL PACK WEEKLY
    public void updateMealPackDaily(Long id, MealPackDaily mealPackDaily) throws Exception {
        try {
            mealPackServiceClient.updateMealPackDaily(id, mealPackDaily);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }
    }


    // CREATE MEAL PACK
    public void createNewMealPackDaily(MealPackDaily mealPackDaily){
        try {
            mealPackServiceClient.createNewMealPackDaily(mealPackDaily);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }
    }
}
