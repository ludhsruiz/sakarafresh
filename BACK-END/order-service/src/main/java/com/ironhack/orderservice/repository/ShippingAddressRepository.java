package com.ironhack.orderservice.repository;

import com.ironhack.orderservice.model.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Long> {

    @Query("SELECT e FROM ShippingAddress e WHERE e.userId = :userId")
    List<ShippingAddress> getShippingAddressByUserId(@Param("userId") Long userId);

}

