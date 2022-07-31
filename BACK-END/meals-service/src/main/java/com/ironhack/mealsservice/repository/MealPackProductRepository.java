package com.ironhack.mealsservice.repository;

import com.ironhack.mealsservice.models.MealPackProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealPackProductRepository extends JpaRepository<MealPackProduct, Long> {

}
