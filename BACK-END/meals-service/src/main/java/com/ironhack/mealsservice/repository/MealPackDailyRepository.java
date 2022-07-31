package com.ironhack.mealsservice.repository;

import com.ironhack.mealsservice.models.MealPackDaily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealPackDailyRepository extends JpaRepository<MealPackDaily, Long> {

}

