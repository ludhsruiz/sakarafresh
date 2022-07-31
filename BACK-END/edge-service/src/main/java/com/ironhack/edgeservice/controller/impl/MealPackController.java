package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.model.MealPack;
import com.ironhack.edgeservice.service.impl.MealPackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(value = "http://localhost:4200")
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
        return mealPackService.getMealPackById(id);

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
        mealPackService.updateMealPack(id, mealPack);
    }

    // CREATE MEAL PACK
    @PostMapping("/meal-packs")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewMealPack(@RequestBody MealPack mealPack){
        mealPackService.createNewMealPack(mealPack);

    }




}
