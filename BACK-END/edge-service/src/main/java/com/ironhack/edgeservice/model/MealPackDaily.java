package com.ironhack.edgeservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MealPackDaily {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Meal PACK Related
    private Long MealPackId;

    // MealPackProduct related
    private Long mealPackProductIdBreakfast;
    private Long mealPackProductIdLunch;
    private Long mealPackProductIdDinner;
    private Long mealPackProductIdSnack;
    private Long mealPackProductIdDessert;
    private Long mealPackProductIdDJuice;





}
