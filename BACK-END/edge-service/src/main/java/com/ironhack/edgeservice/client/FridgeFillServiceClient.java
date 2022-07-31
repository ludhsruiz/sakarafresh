package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.model.FridgeFill;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@FeignClient("fridge-fills-service")
public interface FridgeFillServiceClient {

    @GetMapping("/fridge-fills")
    public List<FridgeFill> getAllFridgeFills();

    @GetMapping("/fridge-fills/{id}")
    public FridgeFill getFridgeFillById(@PathVariable Long id) throws Exception ;

    @DeleteMapping("/fridge-fills/{id}")

    public void deleteFridgeFillId(@PathVariable Long id) throws Exception ;

    @PutMapping("/fridge-fills/{id}")
    public void updateFridgeFill(@PathVariable Long id,  @RequestBody FridgeFill fridgeFill) throws Exception;

    @PostMapping("/fridge-fills")
    public void createNewFridgeFill(@RequestBody FridgeFill fridgeFill);
}
