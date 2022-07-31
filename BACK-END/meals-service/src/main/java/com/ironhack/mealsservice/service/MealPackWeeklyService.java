package com.ironhack.mealsservice.service;


import com.ironhack.mealsservice.models.MealPackWeekly;
import com.ironhack.mealsservice.repository.MealPackWeeklyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealPackWeeklyService {

    @Autowired
    private MealPackWeeklyRepository mealPackWeeklyRepository;



    // ALL MEAL PACKS WEEKLY
    public List<MealPackWeekly> getAllMealPackWeekly(){

        return mealPackWeeklyRepository.findAll();
    }


    // MEAL PACK BY ID
    public Optional<MealPackWeekly> getMealPackWeeklyById(Long id) {
        return mealPackWeeklyRepository.findById(id);
    }


    // DELETE PACK
    public void deleteMealPackWeekly(Long id) throws Exception {
        Optional<MealPackWeekly> maybeMealPackWeekly = mealPackWeeklyRepository.findById(id);
        if(maybeMealPackWeekly.isEmpty()){
            throw new Exception("No MealPack found");
        }
        mealPackWeeklyRepository.delete(maybeMealPackWeekly.get());
    }

    // UPDATE MEALPACK WEEKLY
    public void updateMealPackWeekly(Long id, MealPackWeekly mealPackDaily) throws Exception {
        Optional<MealPackWeekly> maybeMealPackWeekly = mealPackWeeklyRepository.findById(id);
        if(maybeMealPackWeekly.isEmpty()){
            throw new Exception("No Snack found");
        }
        maybeMealPackWeekly.get().setMealPackDailyId1(mealPackDaily.getId());
        maybeMealPackWeekly.get().setMealPackDailyId2(mealPackDaily.getId());
        maybeMealPackWeekly.get().setMealPackDailyId3(mealPackDaily.getId());
        maybeMealPackWeekly.get().setMealPackDailyId4(mealPackDaily.getId());
        maybeMealPackWeekly.get().setMealPackDailyId5(mealPackDaily.getId());
        mealPackWeeklyRepository.save(maybeMealPackWeekly.get());

    }


    // CREATE MEAL PACK
    public void createNewMealPackWeekly(MealPackWeekly mealPackWeekly){
        mealPackWeeklyRepository.save(mealPackWeekly);
    }
}
