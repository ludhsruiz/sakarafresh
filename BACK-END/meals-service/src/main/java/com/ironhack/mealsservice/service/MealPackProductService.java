package com.ironhack.mealsservice.service;

import com.ironhack.mealsservice.models.MealPackDaily;
import com.ironhack.mealsservice.models.MealPackProduct;
import com.ironhack.mealsservice.repository.MealPackProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MealPackProductService {

    @Autowired
    private MealPackProductRepository mealPackProductRepository;


    // ALL MEALPACKS
    public List<MealPackProduct> getAllMealPackProduct() {

        return mealPackProductRepository.findAll();
    }


    // MEAL PACK BY ID
    public Optional<MealPackProduct> getMealPackProductById(Long id) {
        return mealPackProductRepository.findById(id);
    }


    // DELETE PACK
    public void deleteMealPackProduct(Long id) throws Exception {
        Optional<MealPackProduct> maybeMealPackProduct = mealPackProductRepository.findById(id);
        if (maybeMealPackProduct.isEmpty()) {
            throw new Exception("No product found");
        }
        mealPackProductRepository.delete(maybeMealPackProduct.get());
    }

    // UPDATE MEAL PACK WEEKLY
    public void updateMealPackProduct(Long id, MealPackProduct mealPackProduct) throws Exception {
        Optional<MealPackProduct> maybeMealPackProduct = mealPackProductRepository.findById(id);
        if (maybeMealPackProduct.isEmpty()) {
            throw new Exception("No product found");
        }
        maybeMealPackProduct.get().setId(mealPackProduct.getId());
        maybeMealPackProduct.get().setName(mealPackProduct.getName());
        maybeMealPackProduct.get().setImg(mealPackProduct.getImg());
        maybeMealPackProduct.get().setIngredients(mealPackProduct.getIngredients());
        maybeMealPackProduct.get().setFreezable(mealPackProduct.getFreezable());
        maybeMealPackProduct.get().setSelfLife(mealPackProduct.getSelfLife());
        maybeMealPackProduct.get().setEatHot(mealPackProduct.getEatHot());
        maybeMealPackProduct.get().setEatCold(mealPackProduct.getEatCold());
        maybeMealPackProduct.get().setCalories(mealPackProduct.getCalories());
        maybeMealPackProduct.get().setProtein(mealPackProduct.getProtein());
        maybeMealPackProduct.get().setCarbs(mealPackProduct.getCarbs());
        maybeMealPackProduct.get().setFat(mealPackProduct.getFat());
        maybeMealPackProduct.get().setSaturatedFat(mealPackProduct.getSaturatedFat());
        maybeMealPackProduct.get().setSugar(mealPackProduct.getSugar());
        maybeMealPackProduct.get().setFiber(mealPackProduct.getFiber());
        maybeMealPackProduct.get().setSalt(mealPackProduct.getSalt());

        mealPackProductRepository.save(maybeMealPackProduct.get());


    }


    // CREATE MEAL PACK
    public void createNewMealPackProduct(MealPackProduct mealPackProduct) {
        mealPackProductRepository.save(mealPackProduct);
    }
}