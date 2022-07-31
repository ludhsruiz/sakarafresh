package com.ironhack.edgeservice.service.impl;

import com.ironhack.edgeservice.client.MealPackServiceClient;
import com.ironhack.edgeservice.model.MealPackProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MealPackProductService {

    @Autowired
    private MealPackServiceClient mealPackServiceClient;


    public List<MealPackProduct> getAllMealPackProduct() {
        try {
            return mealPackServiceClient.getAllMealPackProduct();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }

    }


    // MEAL PACK BY ID
    public MealPackProduct getMealPackProductById(Long id) {
        try {
            return mealPackServiceClient.getMealPackProductById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }

    }


    // DELETE PACK
    public void deleteMealPackProduct(Long id) throws Exception {
        try {
            mealPackServiceClient.deleteMealPackProduct(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }
    }

    // UPDATE MEAL PACK WEEKLY
    public void updateMealPackProduct(Long id, MealPackProduct mealPackProduct) throws Exception {
        try {
            mealPackServiceClient.updateMealPackProduct(id, mealPackProduct);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }

    }


    // CREATE MEAL PACK
    public void createNewMealPackProduct(MealPackProduct mealPackProduct) {
        try {
            mealPackServiceClient.createNewMealPackProduct(mealPackProduct);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error loading");
        }
    }
}