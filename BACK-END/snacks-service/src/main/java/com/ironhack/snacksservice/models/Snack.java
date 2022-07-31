package com.ironhack.snacksservice.models;

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
public class Snack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private String description;
    private String picture;
    private Double price;
    private Integer quantity;

    // INFORMATION ABOUT PRODUCT
    private String flavor;
    private String benefits;
    private String ingredients;
    private String howToUse;
    private String allergens;
    private String disclaimers;

    //NUTRITIONAL INFO
    private int calories;
    private int protein;
    private int carbohydrates;
    private int fat;
    private int cholesterol;
    private int sodium;
    private int vitaminD;
    private int calcium;
    private int iron;
    private int potassium;
}
