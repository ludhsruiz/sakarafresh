package com.ironhack.mealsservice.models;

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
public class MealPackProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String img;

    //FULL INGREDIENT LIST
    private String ingredients;

    //DETAILS
    private Boolean Freezable;
    private int SelfLife;
    private Boolean EatHot;
    private Boolean EatCold;

    //NUTRITIONAL INFO
    private int Calories;
    private int Protein;
    private int Carbs;
    private int Fat;
    private int SaturatedFat;
    private int Sugar;
    private int Fiber;
    private int Salt;
}
