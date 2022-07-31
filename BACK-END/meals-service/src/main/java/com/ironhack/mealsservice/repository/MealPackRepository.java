package com.ironhack.mealsservice.repository;

import com.ironhack.mealsservice.models.MealPack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealPackRepository extends JpaRepository<MealPack, Long> {

}

