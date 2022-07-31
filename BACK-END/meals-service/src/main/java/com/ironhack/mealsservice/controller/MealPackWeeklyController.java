package com.ironhack.mealsservice.controller;

import com.ironhack.mealsservice.models.MealPack;
import com.ironhack.mealsservice.models.MealPackWeekly;
import com.ironhack.mealsservice.service.MealPackWeeklyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MealPackWeeklyController {

    @Autowired
    private MealPackWeeklyService mealPackWeeklyService;


    // ALL MEAL PACKS
    @GetMapping("/meal-packs-weekly")
    @ResponseStatus(HttpStatus.OK)
    public List<MealPackWeekly> getAllMealPackWeekly(){
        return mealPackWeeklyService.getAllMealPackWeekly();
    }



    // ONE  FULL MODEL
    @GetMapping("/meal-packs-weekly/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MealPackWeekly getMealPackWeeklyById(@PathVariable Long id) throws Exception {
        Optional<MealPackWeekly> maybeMealPackWeekly = mealPackWeeklyService.getMealPackWeeklyById(id);
        if(maybeMealPackWeekly.isEmpty()){
            throw new Exception("No MEAL PACK WEEKLY found");
        }
        return new MealPackWeekly(
                maybeMealPackWeekly.get().getId(),
                maybeMealPackWeekly.get().getMealPackDailyId1(),
                maybeMealPackWeekly.get().getMealPackDailyId2(),
                maybeMealPackWeekly.get().getMealPackDailyId3(),
                maybeMealPackWeekly.get().getMealPackDailyId4(),
                maybeMealPackWeekly.get().getMealPackDailyId5());
    }



    @DeleteMapping("/meal-packs-weekly/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMealPackWeekly(@PathVariable Long id) throws Exception {
        mealPackWeeklyService.deleteMealPackWeekly(id);
    }


    // EDIT
    @PutMapping("/meal-packs-weekly/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateMealPackWeekly(@PathVariable Long id,  @RequestBody MealPackWeekly mealPackWeekly) throws Exception {
        MealPackWeekly updatedMealPackWeekly = new MealPackWeekly(
                mealPackWeekly.getId(),
                mealPackWeekly.getMealPackDailyId1(),
                mealPackWeekly.getMealPackDailyId2(),
                mealPackWeekly.getMealPackDailyId3(),
                mealPackWeekly.getMealPackDailyId4(),
                mealPackWeekly.getMealPackDailyId5());
        mealPackWeeklyService.updateMealPackWeekly(id, updatedMealPackWeekly);


    }

    // CREATE MEAL PACK
    @PostMapping("/meal-pack-weekly")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewMealPackWeekly(@RequestBody MealPackWeekly mealPackWeekly){
        MealPackWeekly newMealPackWeekly = new MealPackWeekly(
                mealPackWeekly.getId(),
                mealPackWeekly.getMealPackDailyId1(),
                mealPackWeekly.getMealPackDailyId2(),
                mealPackWeekly.getMealPackDailyId3(),
                mealPackWeekly.getMealPackDailyId4(),
                mealPackWeekly.getMealPackDailyId5());
        mealPackWeeklyService.createNewMealPackWeekly(newMealPackWeekly);

    }



}
