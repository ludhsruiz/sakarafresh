package com.ironhack.fridgefillsservice.controller;

import com.ironhack.fridgefillsservice.model.FridgeFill;
import com.ironhack.fridgefillsservice.service.FridgeFillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class FridgeFillController {

    @Autowired
    private FridgeFillService fridgeFillService;


    // ALL FRIDGE FILLS
    @GetMapping("/fridge-fills")
    @ResponseStatus(HttpStatus.OK)
    public List<FridgeFill> getAllFridgeFills(){
        return fridgeFillService.getAllFridgeFill();
    }



    // ONE FRIDGE FILL  FULL MODEL
    @GetMapping("/fridge-fills/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FridgeFill getFridgeFillById(@PathVariable Long id) throws Exception {
        Optional<FridgeFill> maybeFridgeFill = fridgeFillService.getFridgeFillById(id);
        if(maybeFridgeFill.isEmpty()){
            throw new Exception("No Fridge Fill found");
        }
        return new FridgeFill(
            maybeFridgeFill.get().getId(),
            maybeFridgeFill.get().getMealName(),
            maybeFridgeFill.get().getDescription(),
            maybeFridgeFill.get().getPicture(),
            //details
            maybeFridgeFill.get().getFreezable(),
            maybeFridgeFill.get().getSelfLife(),
            maybeFridgeFill.get().getEatHot(),
            maybeFridgeFill.get().getEatCold(),

            maybeFridgeFill.get().getTotalCalories(),
            maybeFridgeFill.get().getIngredients(),

            //nutritionalinfo
            maybeFridgeFill.get().getCalories(),
            maybeFridgeFill.get().getProtein(),
            maybeFridgeFill.get().getCarbs(),
            maybeFridgeFill.get().getFat(),
            maybeFridgeFill.get().getSaturatedFat(),
            maybeFridgeFill.get().getSugar(),
            maybeFridgeFill.get().getFiber(),
            maybeFridgeFill.get().getSalt());

    }




    @DeleteMapping("/fridge-fills/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFridgeFillId(@PathVariable Long id) throws Exception {
        fridgeFillService.deleteFridgeFill(id);
    }


    // EDIT OR CREATE FULL SMACK
    @PutMapping("/fridge-fills/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateFridgeFill(@PathVariable Long id,  @RequestBody FridgeFill fridgeFill) throws Exception {
        FridgeFill updateFridgeFill = new FridgeFill(
                fridgeFill.getId(),
                fridgeFill.getMealName(),
                fridgeFill.getDescription(),
                fridgeFill.getPicture(),
                //details
                fridgeFill.getFreezable(),
                fridgeFill.getSelfLife(),
                fridgeFill.getEatHot(),
                fridgeFill.getEatCold(),

                fridgeFill.getTotalCalories(),
                fridgeFill.getIngredients(),

                //nutritionalinfo
                fridgeFill.getCalories(),
                fridgeFill.getProtein(),
                fridgeFill.getCarbs(),
                fridgeFill.getFat(),
                fridgeFill.getSaturatedFat(),
                fridgeFill.getSugar(),
                fridgeFill.getFiber(),
                fridgeFill.getSalt());

        fridgeFillService.updateFridgeFill(id, fridgeFill);
    }

    @PostMapping("/fridge-fills")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewFridgeFill(@RequestBody FridgeFill fridgeFill){
        FridgeFill newFridgeFill = new FridgeFill(
                fridgeFill.getId(),
                fridgeFill.getMealName(),
                fridgeFill.getDescription(),
                fridgeFill.getPicture(),
                //details
                fridgeFill.getFreezable(),
                fridgeFill.getSelfLife(),
                fridgeFill.getEatHot(),
                fridgeFill.getEatCold(),

                fridgeFill.getTotalCalories(),
                fridgeFill.getIngredients(),

                //nutritionalinfo
                fridgeFill.getCalories(),
                fridgeFill.getProtein(),
                fridgeFill.getCarbs(),
                fridgeFill.getFat(),
                fridgeFill.getSaturatedFat(),
                fridgeFill.getSugar(),
                fridgeFill.getFiber(),
                fridgeFill.getSalt());
        fridgeFillService.createNewFridgeFill(fridgeFill);
    }
}
