package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.model.MealPackDaily;
import com.ironhack.edgeservice.service.impl.MealPackDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(value = "http://localhost:4200")
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
        return mealPackDailyService.getMealPackDailyById(id);

    }



    @DeleteMapping("/meal-packs-daily/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMealPackDaily(@PathVariable Long id) throws Exception {
        mealPackDailyService.deleteMealPackDaily(id);
    }


    // EDIT
    @PutMapping("/meal-packs-daily/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateMealPackDaily(@PathVariable Long id,  @RequestBody MealPackDaily mealPackDaily) throws Exception {

        mealPackDailyService.updateMealPackDaily(id, mealPackDaily);

    }

    // CREATE MEAL PACK
    @PostMapping("/meal-packs-daily")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewMealPackDaily(@RequestBody MealPackDaily mealPackDaily){
        mealPackDailyService.createNewMealPackDaily(mealPackDaily);

    }

}
