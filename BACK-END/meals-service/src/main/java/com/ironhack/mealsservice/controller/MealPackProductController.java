package com.ironhack.mealsservice.controller;

import com.ironhack.mealsservice.models.MealPackProduct;
import com.ironhack.mealsservice.service.MealPackProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MealPackProductController {

    @Autowired
    private MealPackProductService mealPackProductService;

    // ALL
    @GetMapping("/meal-packs-product")
    @ResponseStatus(HttpStatus.OK)
    public List<MealPackProduct> getAllMealPackProduct(){
        return mealPackProductService.getAllMealPackProduct();
    }



    //GET BY ID
    @GetMapping("/meal-packs-product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MealPackProduct getMealPackProductById(@PathVariable Long id) throws Exception {
        Optional<MealPackProduct> maybeMealPackProduct = mealPackProductService.getMealPackProductById(id);
        if(maybeMealPackProduct.isEmpty()){
            throw new Exception("No product found");
        }
        return new MealPackProduct(
                maybeMealPackProduct.get().getId(),
                maybeMealPackProduct.get().getName(),
                maybeMealPackProduct.get().getImg(),
                maybeMealPackProduct.get().getIngredients(),
                maybeMealPackProduct.get().getFreezable(),
                maybeMealPackProduct.get().getSelfLife(),
                maybeMealPackProduct.get().getEatHot(),
                maybeMealPackProduct.get().getEatCold(),
                maybeMealPackProduct.get().getCalories(),
                maybeMealPackProduct.get().getProtein(),
                maybeMealPackProduct.get().getCarbs(),
                maybeMealPackProduct.get().getFat(),
                maybeMealPackProduct.get().getSaturatedFat(),
                maybeMealPackProduct.get().getSugar(),
                maybeMealPackProduct.get().getFiber(),
                maybeMealPackProduct.get().getSalt());

    }



    @DeleteMapping("/meal-packs-product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMealPackProduct(@PathVariable Long id) throws Exception {
        mealPackProductService.deleteMealPackProduct(id);
    }


    // EDIT
    @PutMapping("/meal-packs-product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateMealPackProduct(@PathVariable Long id,  @RequestBody MealPackProduct mealPackProduct) throws Exception {
        MealPackProduct updatedMealPackProduct = new MealPackProduct(
                mealPackProduct.getId(),
                mealPackProduct.getName(),
                mealPackProduct.getImg(),
                mealPackProduct.getIngredients(),
                mealPackProduct.getFreezable(),
                mealPackProduct.getSelfLife(),
                mealPackProduct.getEatHot(),
                mealPackProduct.getEatCold(),
                mealPackProduct.getCalories(),
                mealPackProduct.getProtein(),
                mealPackProduct.getCarbs(),
                mealPackProduct.getFat(),
                mealPackProduct.getSaturatedFat(),
                mealPackProduct.getSugar(),
                mealPackProduct.getFiber(),
                mealPackProduct.getSalt());
        mealPackProductService.updateMealPackProduct(id, updatedMealPackProduct);
    }


    // CREATE MEAL PACK
    @PostMapping("/meal-packs-product")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewMealPackProduct(@RequestBody MealPackProduct mealPackProduct){
        MealPackProduct newMealPackProduct = new MealPackProduct(
                mealPackProduct.getId(),
                mealPackProduct.getName(),
                mealPackProduct.getImg(),
                mealPackProduct.getIngredients(),
                mealPackProduct.getFreezable(),
                mealPackProduct.getSelfLife(),
                mealPackProduct.getEatHot(),
                mealPackProduct.getEatCold(),
                mealPackProduct.getCalories(),
                mealPackProduct.getProtein(),
                mealPackProduct.getCarbs(),
                mealPackProduct.getFat(),
                mealPackProduct.getSaturatedFat(),
                mealPackProduct.getSugar(),
                mealPackProduct.getFiber(),
                mealPackProduct.getSalt());
        mealPackProductService.createNewMealPackProduct(newMealPackProduct);

    }


}
