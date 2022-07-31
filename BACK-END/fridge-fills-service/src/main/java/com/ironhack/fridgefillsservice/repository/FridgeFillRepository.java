package com.ironhack.fridgefillsservice.repository;

import com.ironhack.fridgefillsservice.model.FridgeFill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FridgeFillRepository extends JpaRepository<FridgeFill, Long> {

}

