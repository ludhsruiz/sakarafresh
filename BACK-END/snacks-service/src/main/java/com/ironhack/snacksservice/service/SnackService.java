package com.ironhack.snacksservice.service;

import com.ironhack.snacksservice.models.Snack;
import com.ironhack.snacksservice.repository.SnackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SnackService {

    @Autowired
    private SnackRepository snackRepository;

    // ALL SNACKS
    public List<Snack> getAllSnacks(){

        return snackRepository.findAll();
    }

    //SNACK BY ID
    public Optional<Snack> getSnackById(Long id) {
        return snackRepository.findById(id);

    }

    // DELETE SNACK
    public void deleteSnack(Long id) throws Exception {
        Optional<Snack> maybeSnack = snackRepository.findById(id);
        if(maybeSnack.isEmpty()){
            throw new Exception("No Snack found");
        }
        snackRepository.delete(maybeSnack.get());
    }

    // UPDATE SNACK
    public void updateSnack(Long id, Snack snack) throws Exception {
        Optional<Snack> maybeSnack = snackRepository.findById(id);
        if(maybeSnack.isEmpty()){
            throw new Exception("No Snack found");
        }
        maybeSnack.get().setProductName(snack.getProductName());
        maybeSnack.get().setDescription(snack.getDescription());
        maybeSnack.get().setPicture(snack.getPicture());
        maybeSnack.get().setPrice(snack.getPrice());
        maybeSnack.get().setQuantity(snack.getQuantity());
        //details
        maybeSnack.get().setFlavor(snack.getFlavor());
        maybeSnack.get().setBenefits(snack.getBenefits());
        maybeSnack.get().setIngredients(snack.getIngredients());
        maybeSnack.get().setHowToUse(snack.getHowToUse());
        maybeSnack.get().setAllergens(snack.getAllergens());
        maybeSnack.get().setDisclaimers(snack.getDisclaimers());

        //nutritional info
        maybeSnack.get().setCalories(snack.getCalories());
        maybeSnack.get().setProtein(snack.getProtein());
        maybeSnack.get().setCarbohydrates(snack.getCarbohydrates());
        maybeSnack.get().setFat(snack.getFat());
        maybeSnack.get().setCholesterol(snack.getCholesterol());
        maybeSnack.get().setSodium(snack.getSodium());
        maybeSnack.get().setVitaminD(snack.getVitaminD());
        maybeSnack.get().setCalcium(snack.getCalcium());
        maybeSnack.get().setIron(snack.getIron());
        maybeSnack.get().setPotassium(snack.getPotassium());
        snackRepository.save(maybeSnack.get());
    }


    // CREATE SNACK
    public void createNewSnack(Snack snack){
        snackRepository.save(snack);
    }
}
