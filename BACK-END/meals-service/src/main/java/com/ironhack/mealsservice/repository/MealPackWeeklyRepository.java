package com.ironhack.mealsservice.repository;

import com.ironhack.mealsservice.models.MealPackWeekly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealPackWeeklyRepository extends JpaRepository<MealPackWeekly, Long> {


}
