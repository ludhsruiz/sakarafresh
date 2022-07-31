package com.ironhack.mealsservice.service;

import com.ironhack.mealsservice.models.MealPackDaily;
import com.ironhack.mealsservice.repository.MealPackDailyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealPackDailyService {

    @Autowired
    private MealPackDailyRepository mealPackDailyRepository;

    // ALL MEALPACKS
    public List<MealPackDaily> getAllMealPackDaily(){

        return mealPackDailyRepository.findAll();
    }


    // MEAL PACK BY ID
    public Optional<MealPackDaily> getMealPackDailyById(Long id) {
        return mealPackDailyRepository.findById(id);
    }


    // DELETE PACK
    public void deleteMealPackDaily(Long id) throws Exception {
        Optional<MealPackDaily> maybeMealPackDaily = mealPackDailyRepository.findById(id);
        if(maybeMealPackDaily.isEmpty()){
            throw new Exception("No MealPack found");
        }
        mealPackDailyRepository.delete(maybeMealPackDaily.get());
    }

    // UPDATE MEAL PACK WEEKLY
    public void updateMealPackDaily(Long id, MealPackDaily mealPackDaily) throws Exception {
        Optional<MealPackDaily> maybeMealPackDaily = mealPackDailyRepository.findById(id);
        if(maybeMealPackDaily.isEmpty()){
            throw new Exception("No Snack found");
        }
        maybeMealPackDaily.get().setMealPackId(mealPackDaily.getId());
        maybeMealPackDaily.get().setMealPackProductIdBreakfast(mealPackDaily.getId());
        maybeMealPackDaily.get().setMealPackProductIdLunch(mealPackDaily.getId());
        maybeMealPackDaily.get().setMealPackProductIdDinner(mealPackDaily.getId());
        maybeMealPackDaily.get().setMealPackProductIdSnack(mealPackDaily.getId());
        maybeMealPackDaily.get().setMealPackProductIdDessert(mealPackDaily.getId());
        maybeMealPackDaily.get().setMealPackProductIdDJuice(mealPackDaily.getId());
        mealPackDailyRepository.save(maybeMealPackDaily.get());

    }


    // CREATE MEAL PACK
    public void createNewMealPackDaily(MealPackDaily mealPackDaily){
        mealPackDailyRepository.save(mealPackDaily);
    }
}
