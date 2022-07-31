package com.ironhack.orderservice.repository;

import com.ironhack.orderservice.model.SnackOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SnackOrderRepository extends JpaRepository<SnackOrder, Long> {

    @Query("SELECT e FROM SnackOrder e WHERE e.userId = :userId")
    List<SnackOrder> getSnackOrderByUserId(@Param("userId") Long userId);

}

