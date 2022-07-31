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
public class MealPackWeekly {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // PER WEEK (optional)
    private Long mealPackDailyId1;
    private Long mealPackDailyId2;
    private Long mealPackDailyId3;
    private Long mealPackDailyId4;
    private Long mealPackDailyId5;
}
