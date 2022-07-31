package com.ironhack.snacksservice.controller;

import com.ironhack.snacksservice.models.Snack;
import com.ironhack.snacksservice.service.SnackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SnackController {

    @Autowired
    private SnackService snackService;

    // ALL SNACKS
    @GetMapping("/snacks")
    @ResponseStatus(HttpStatus.OK)
    public List<Snack> getAllSnacks(){
        return snackService.getAllSnacks();
    }



    // ONE SNACK FULL MODEL
    @GetMapping("/snacks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Snack getSnackById(@PathVariable Long id) throws Exception {
        Optional<Snack> maybeSnack = snackService.getSnackById(id);
        if(maybeSnack.isEmpty()){
            throw new Exception("No Snack found");
        }
        return new Snack(
        maybeSnack.get().getId(),
        maybeSnack.get().getProductName(),
        maybeSnack.get().getDescription(),
        maybeSnack.get().getPicture(),
        maybeSnack.get().getPrice(),
        maybeSnack.get().getQuantity(),
        //details
        maybeSnack.get().getFlavor(),
        maybeSnack.get().getBenefits(),
        maybeSnack.get().getIngredients(),
        maybeSnack.get().getHowToUse(),
        maybeSnack.get().getAllergens(),
        maybeSnack.get().getDisclaimers(),

                //nutritional info
        maybeSnack.get().getCalories(),
        maybeSnack.get().getProtein(),
        maybeSnack.get().getCarbohydrates(),
        maybeSnack.get().getFat(),
        maybeSnack.get().getCholesterol(),
        maybeSnack.get().getSodium(),
        maybeSnack.get().getVitaminD(),
        maybeSnack.get().getCalcium(),
        maybeSnack.get().getIron(),
        maybeSnack.get().getPotassium());
    }





    @DeleteMapping("/snacks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSnackId(@PathVariable Long id) throws Exception {
        snackService.deleteSnack(id);
    }


    // EDIT OR CREATE FULL SMACK
    @PutMapping("/snacks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateSnack(@PathVariable Long id,  @RequestBody Snack snack) throws Exception {
        Snack updateSnack = new Snack(
                snack.getId(),
                snack.getProductName(),
                snack.getDescription(),
                snack.getPicture(),
                snack.getPrice(),
                snack.getQuantity(),
                //details
                snack.getFlavor(),
                snack.getBenefits(),
                snack.getIngredients(),
                snack.getHowToUse(),
                snack.getAllergens(),
                snack.getDisclaimers(),

                //nutritional info
                snack.getCalories(),
                snack.getProtein(),
                snack.getCarbohydrates(),
                snack.getFat(),
                snack.getCholesterol(),
                snack.getSodium(),
                snack.getVitaminD(),
                snack.getCalcium(),
                snack.getIron(),
                snack.getPotassium());
        snackService.updateSnack(id, snack);
    }

    @PostMapping("/snacks")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewSnack(@RequestBody Snack snack){
        Snack newSnack = new Snack(
                snack.getId(),
                snack.getProductName(),
                snack.getDescription(),
                snack.getPicture(),
                snack.getPrice(),
                snack.getQuantity(),
                //details
                snack.getFlavor(),
                snack.getBenefits(),
                snack.getIngredients(),
                snack.getHowToUse(),
                snack.getAllergens(),
                snack.getDisclaimers(),

                //nutritional info
                snack.getCalories(),
                snack.getProtein(),
                snack.getCarbohydrates(),
                snack.getFat(),
                snack.getCholesterol(),
                snack.getSodium(),
                snack.getVitaminD(),
                snack.getCalcium(),
                snack.getIron(),
                snack.getPotassium());
        snackService.createNewSnack(snack);
    }


}
