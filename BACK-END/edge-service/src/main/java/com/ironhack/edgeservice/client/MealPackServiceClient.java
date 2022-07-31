package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.model.MealPack;
import com.ironhack.edgeservice.model.MealPackDaily;
import com.ironhack.edgeservice.model.MealPackProduct;
import com.ironhack.edgeservice.model.MealPackWeekly;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient("meal-pack-service")
public interface MealPackServiceClient {


    // ALL MEAL PACKS
    @GetMapping("/meal-packs")
    public List<MealPack> getAllMealPack();

    @GetMapping("/meal-packs/{id}")
    public MealPack getMealPackById(@PathVariable Long id) throws Exception ;


    @DeleteMapping("/meal-packs/{id}")
    public void deleteMealPack(@PathVariable Long id) throws Exception;

    // EDIT
    @PutMapping("/meal-packs/{id}")
    public void updateMealPack(@PathVariable Long id,  @RequestBody MealPack mealPack) throws Exception;

    // CREATE MEAL PACK
    @PostMapping("/meal-packs")
    public void createNewMealPack(@RequestBody MealPack mealPack);



    ////////////////////

    // ALL
    @GetMapping("/meal-packs-product")
    public List<MealPackProduct> getAllMealPackProduct();

    //GET BY ID
    @GetMapping("/meal-packs-product/{id}")
    public MealPackProduct getMealPackProductById(@PathVariable Long id) throws Exception;


    @DeleteMapping("/meal-packs-product/{id}")
    public void deleteMealPackProduct(@PathVariable Long id) throws Exception;

    // EDIT
    @PutMapping("/meal-packs-product/{id}")
    public void updateMealPackProduct(@PathVariable Long id,  @RequestBody MealPackProduct mealPackProduct) throws Exception ;


    @PostMapping("/meal-packs-product")
    public void createNewMealPackProduct(@RequestBody MealPackProduct mealPackProduct);



    ////////////////////



    // ALL MEAL PACKS
    @GetMapping("/meal-packs-weekly")
    public List<MealPackWeekly> getAllMealPackWeekly();

    // ONE  FULL MODEL
    @GetMapping("/meal-packs-weekly/{id}")
    public MealPackWeekly getMealPackWeeklyById(@PathVariable Long id) throws Exception;


    @DeleteMapping("/meal-packs-weekly/{id}")
    public void deleteMealPackWeekly(@PathVariable Long id) throws Exception;

    @PutMapping("/meal-packs-weekly/{id}")
    public void updateMealPackWeekly(@PathVariable Long id,  @RequestBody MealPackWeekly mealPackWeekly) throws Exception ;


    @PostMapping("/meal-pack-weekly")
    public void createNewMealPackWeekly(@RequestBody MealPackWeekly mealPackWeekly);


    ////////////////////////////




    @GetMapping("/meal-packs-daily")
    public List<MealPackDaily> getAllMealPackDaily();


    @GetMapping("/meal-packs-daily/{id}")
    public MealPackDaily getMealPackDailyById(@PathVariable Long id) throws Exception;


    @DeleteMapping("/meal-packs-daily/{id}")
    public void deleteMealPackDaily(@PathVariable Long id) throws Exception ;


    @PutMapping("/meal-packs-daily/{id}")
    public void updateMealPackDaily(@PathVariable Long id,  @RequestBody MealPackDaily mealPackDaily) throws Exception ;

    @PostMapping("/meal-packs-daily")
    public void createNewMealPackDaily(@RequestBody MealPackDaily mealPackDaily);

}
