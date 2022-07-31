package com.ironhack.mealsservice.controller;

import com.ironhack.mealsservice.models.MealPack;
import com.ironhack.mealsservice.service.MealPackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MealPackController {


    @Autowired
    private MealPackService mealPackService;

    // ALL MEAL PACKS
    @GetMapping("/meal-packs")
    @ResponseStatus(HttpStatus.OK)
    public List<MealPack> getAllMealPack(){
        return mealPackService.getAllMealPack();
    }



    // ONE  FULL MODEL
    @GetMapping("/meal-packs/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MealPack getMealPackById(@PathVariable Long id) throws Exception {
        Optional<MealPack> maybeMealPack = mealPackService.getMealPackById(id);
        if(maybeMealPack.isEmpty()){
            throw new Exception("No MEAL PACK found");
        }
        return new MealPack(
        maybeMealPack.get().getId(),
        maybeMealPack.get().getMealName(),
        maybeMealPack.get().getDescription(),
        maybeMealPack.get().getTotalCalories(),
        maybeMealPack.get().getTotalDays(),
        maybeMealPack.get().getPrize(),
        maybeMealPack.get().getPicture(),
        // menu info
        maybeMealPack.get().getDetails(),
        // perweek
        maybeMealPack.get().getMealPackWeeklyId1(),
        maybeMealPack.get().getMealPackWeeklyId2(),
        maybeMealPack.get().getMealPackWeeklyId3());


    }





    @DeleteMapping("/meal-packs/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMealPack(@PathVariable Long id) throws Exception {
        mealPackService.deleteMealPack(id);
    }


    // EDIT
    @PutMapping("/meal-packs/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateMealPack(@PathVariable Long id,  @RequestBody MealPack mealPack) throws Exception {
        MealPack updatedMealPack = new MealPack(
                mealPack.getId(),
                mealPack.getMealName(),
                mealPack.getDescription(),
                mealPack.getTotalCalories(),
                mealPack.getTotalDays(),
                mealPack.getPrize(),
                mealPack.getPicture(),
                // menu info
                mealPack.getDetails(),
                // perweek
                mealPack.getMealPackWeeklyId1(),
                mealPack.getMealPackWeeklyId2(),
                mealPack.getMealPackWeeklyId3());
        mealPackService.updateMealPack(id, updatedMealPack);
    }

    // CREATE MEAL PACK
    @PostMapping("/meal-packs")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewMealPack(@RequestBody MealPack mealPack){
        MealPack newMealPack = new MealPack(
                mealPack.getId(),
                mealPack.getMealName(),
                mealPack.getDescription(),
                mealPack.getTotalCalories(),
                mealPack.getTotalDays(),
                mealPack.getPrize(),
                mealPack.getPicture(),
                // menu info
                mealPack.getDetails(),
                // perweek
                mealPack.getMealPackWeeklyId1(),
                mealPack.getMealPackWeeklyId2(),
                mealPack.getMealPackWeeklyId3());
        mealPackService.createNewMealPack(newMealPack);

    }



}
