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
public class FridgeFill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String mealName;
    private String description;
    private String picture;

    private Boolean freezable;
    private int selfLife;
    private Boolean eatHot;
    private Boolean eatCold;

    //MORE INFO BUTTON
    private int totalCalories;

    //FULL INGREDIENT LIST
    private String ingredients;

    //NUTRITIONAL INFO
    private int calories;
    private int protein;
    private int carbs;
    private int fat;
    private int saturatedFat;
    private int sugar;
    private int fiber;
    private int salt;



}

