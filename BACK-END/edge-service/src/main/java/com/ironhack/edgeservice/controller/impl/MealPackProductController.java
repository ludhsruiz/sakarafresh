package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.model.MealPackProduct;
import com.ironhack.edgeservice.service.impl.MealPackProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(value = "http://localhost:4200")
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
        return mealPackProductService.getMealPackProductById(id);

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
              mealPackProductService.updateMealPackProduct(id, mealPackProduct);
    }


    // CREATE MEAL PACK
    @PostMapping("/meal-packs-product")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewMealPackProduct(@RequestBody MealPackProduct mealPackProduct){
        mealPackProductService.createNewMealPackProduct(mealPackProduct);

    }


}
