package com.ironhack.mealsservice.service;

import com.ironhack.mealsservice.models.MealPack;
import com.ironhack.mealsservice.repository.MealPackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MealPackService {

    @Autowired
    private MealPackRepository mealPackRepository;

    // ALL MEAL PACKS
    public List<MealPack> getAllMealPack() {
        return mealPackRepository.findAll();
    }

    // MEAL PACK BY ID
    public Optional<MealPack> getMealPackById(Long id) {
        return mealPackRepository.findById(id);
    }


    // DELETE PACK
    public void deleteMealPack(Long id) throws Exception {
        Optional<MealPack> maybeMealPack = mealPackRepository.findById(id);
        if(maybeMealPack.isEmpty()){
            throw new Exception("No MealPack found");
        }
        mealPackRepository.delete(maybeMealPack.get());
    }

    // UPDATE MEALPACK
    public void updateMealPack(Long id, MealPack mealPack) throws Exception {
        Optional<MealPack> maybeMealPack = mealPackRepository.findById(id);
        if(maybeMealPack.isEmpty()){
            throw new Exception("No Snack found");
        }
        maybeMealPack.get().setMealName(mealPack.getMealName());
        maybeMealPack.get().setDescription(mealPack.getDescription());
        maybeMealPack.get().setTotalCalories(mealPack.getTotalCalories());
        maybeMealPack.get().setTotalDays(mealPack.getTotalDays());
        maybeMealPack.get().setPrize(mealPack.getPrize());
        maybeMealPack.get().setPicture(mealPack.getPicture());
        // menu info
        maybeMealPack.get().setDetails(mealPack.getDetails());
        // perweek
        maybeMealPack.get().setMealPackWeeklyId1(mealPack.getMealPackWeeklyId1());
        maybeMealPack.get().setMealPackWeeklyId2(mealPack.getMealPackWeeklyId2());
        maybeMealPack.get().setMealPackWeeklyId3(mealPack.getMealPackWeeklyId3());
        mealPackRepository.save(maybeMealPack.get());
   }


    // CREATE MEAL PACK
    public void createNewMealPack(MealPack mealPack){
        mealPackRepository.save(mealPack);
    }
}
