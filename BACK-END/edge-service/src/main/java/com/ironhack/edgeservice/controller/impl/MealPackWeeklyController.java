package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.model.MealPackWeekly;
import com.ironhack.edgeservice.service.impl.MealPackWeeklyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(value = "http://localhost:4200")
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
        return mealPackWeeklyService.getMealPackWeeklyById(id);
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
        mealPackWeeklyService.updateMealPackWeekly(id, mealPackWeekly);
    }

    // CREATE MEAL PACK
    @PostMapping("/meal-packs-weekly")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewMealPackWeekly(@RequestBody MealPackWeekly mealPackWeekly){
        mealPackWeeklyService.createNewMealPackWeekly(mealPackWeekly);

    }



}
