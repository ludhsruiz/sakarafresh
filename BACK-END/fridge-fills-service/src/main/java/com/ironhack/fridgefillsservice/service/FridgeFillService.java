package com.ironhack.fridgefillsservice.service;

import com.ironhack.fridgefillsservice.model.FridgeFill;
import com.ironhack.fridgefillsservice.repository.FridgeFillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FridgeFillService {

    @Autowired
    private FridgeFillRepository fridgeFillRepository;


    // ALL FRIDGE FILLS
    public List<FridgeFill> getAllFridgeFill(){

        return fridgeFillRepository.findAll();
    }

    //FRIDGE FILL BY ID
    public Optional<FridgeFill> getFridgeFillById(Long id) {
        return fridgeFillRepository.findById(id);

    }

    // DELETE FRIDGE FILL
    public void deleteFridgeFill(Long id) throws Exception {
        Optional<FridgeFill> maybeFridgeFill= fridgeFillRepository.findById(id);
        if(maybeFridgeFill.isEmpty()){
            throw new Exception("No Fridge Fill found");
        }
        fridgeFillRepository.delete(maybeFridgeFill.get());
    }


    // UPDATE FRIDGE FILL
    public void updateFridgeFill(Long id, FridgeFill fridgeFill) throws Exception {
        Optional<FridgeFill> maybeFridgeFill = fridgeFillRepository.findById(id);
        if(maybeFridgeFill.isEmpty()){
            throw new Exception("No Fridge Fill found");
        }
        maybeFridgeFill.get().setMealName(fridgeFill.getMealName());
        maybeFridgeFill.get().setDescription(fridgeFill.getDescription());
        maybeFridgeFill.get().setPicture(fridgeFill.getPicture());
        //details
        maybeFridgeFill.get().setFreezable(fridgeFill.getFreezable());
        maybeFridgeFill.get().setSelfLife(fridgeFill.getSelfLife());
        maybeFridgeFill.get().setEatHot(fridgeFill.getEatHot());
        maybeFridgeFill.get().setEatCold(fridgeFill.getEatCold());

        maybeFridgeFill.get().setTotalCalories(fridgeFill.getTotalCalories());
        maybeFridgeFill.get().setIngredients(fridgeFill.getIngredients());

        //nutritionalinfo
        maybeFridgeFill.get().setCalories(fridgeFill.getCalories());
        maybeFridgeFill.get().setProtein(fridgeFill.getProtein());
        maybeFridgeFill.get().setCarbs(fridgeFill.getCarbs());
        maybeFridgeFill.get().setFat(fridgeFill.getFat());
        maybeFridgeFill.get().setSaturatedFat(fridgeFill.getSaturatedFat());
        maybeFridgeFill.get().setSugar(fridgeFill.getSugar());
        maybeFridgeFill.get().setFiber(fridgeFill.getFiber());
        maybeFridgeFill.get().setSalt(fridgeFill.getSalt());

        fridgeFillRepository.save(maybeFridgeFill.get());
    }



    // CREATE FRIDGE FILL
    public void createNewFridgeFill(FridgeFill fridgeFill){
        fridgeFillRepository.save(fridgeFill);
    }


}
