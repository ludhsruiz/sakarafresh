package com.ironhack.snacksservice.repository;

import com.ironhack.snacksservice.models.Snack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnackRepository extends JpaRepository<Snack, Long> {

}
