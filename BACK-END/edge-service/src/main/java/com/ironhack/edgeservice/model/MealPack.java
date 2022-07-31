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
public class MealPack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String MealName;
    private String description;
    private int totalCalories;
    private int totalDays;
    private Double Prize; // prize per day (6 dishes) _ order by subscription type
    private String picture;

    // MENU IN DEEP INFORMATION
    private String Details;

    // PER WEEK (optional)
    private Long mealPackWeeklyId1;
    private Long mealPackWeeklyId2;
    private Long mealPackWeeklyId3;




}

