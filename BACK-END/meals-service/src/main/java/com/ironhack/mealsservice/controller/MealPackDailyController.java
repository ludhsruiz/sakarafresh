package com.ironhack.mealsservice.controller;

import com.ironhack.mealsservice.models.MealPackDaily;
import com.ironhack.mealsservice.service.MealPackDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class MealPackDailyController {


    @Autowired
    private MealPackDailyService mealPackDailyService;


    // ALL MEAL PACKS
    @GetMapping("/meal-packs-daily")
    @ResponseStatus(HttpStatus.OK)
    public List<MealPackDaily> getAllMealPackDaily(){
        return mealPackDailyService.getAllMealPackDaily();
    }



    @GetMapping("/meal-packs-daily/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MealPackDaily getMealPackDailyById(@PathVariable Long id) throws Exception {
        Optional<MealPackDaily> maybeMealPackDaily = mealPackDailyService.getMealPackDailyById(id);
        if(maybeMealPackDaily.isEmpty()){
            throw new Exception("No MEAL PACK DAILY found");
        }
        return new MealPackDaily(
                maybeMealPackDaily.get().getId(),
                maybeMealPackDaily.get().getMealPackId(),
                maybeMealPackDaily.get().getMealPackProductIdBreakfast(),
                maybeMealPackDaily.get().getMealPackProductIdLunch(),
                maybeMealPackDaily.get().getMealPackProductIdDinner(),
                maybeMealPackDaily.get().getMealPackProductIdSnack(),
                maybeMealPackDaily.get().getMealPackProductIdDessert(),
                maybeMealPackDaily.get().getMealPackProductIdDJuice());

    }



    @DeleteMapping("/meal-packs-daily/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMealPackDaily(@PathVariable Long id) throws Exception {
        mealPackDailyService.deleteMealPackDaily(id);
    }


    // EDIT
    @PutMapping("/meal-pack-daily/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateMealPackDaily(@PathVariable Long id,  @RequestBody MealPackDaily mealPackDaily) throws Exception {
        MealPackDaily updatedMealPackDaily = new MealPackDaily(
                mealPackDaily.getId(),
                mealPackDaily.getMealPackId(),
                mealPackDaily.getMealPackProductIdBreakfast(),
                mealPackDaily.getMealPackProductIdLunch(),
                mealPackDaily.getMealPackProductIdDinner(),
                mealPackDaily.getMealPackProductIdSnack(),
                mealPackDaily.getMealPackProductIdDessert(),
                mealPackDaily.getMealPackProductIdDJuice());
        mealPackDailyService.updateMealPackDaily(id, updatedMealPackDaily);

    }

    // CREATE MEAL PACK
    @PostMapping("/meal-packs-daily")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewMealPackDaily(@RequestBody MealPackDaily mealPackDaily){
        MealPackDaily newMealPackDaily = new MealPackDaily(
                mealPackDaily.getId(),
                mealPackDaily.getMealPackId(),
                mealPackDaily.getMealPackProductIdBreakfast(),
                mealPackDaily.getMealPackProductIdLunch(),
                mealPackDaily.getMealPackProductIdDinner(),
                mealPackDaily.getMealPackProductIdSnack(),
                mealPackDaily.getMealPackProductIdDessert(),
                mealPackDaily.getMealPackProductIdDJuice());
        mealPackDailyService.createNewMealPackDaily(newMealPackDaily);

    }

}
