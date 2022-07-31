package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.model.Snack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient("snack-service")
public interface SnackServiceClient {
    // ALL SNACKS
    @GetMapping("/snacks")
    public List<Snack> getAllSnacks();

    // ONE SNACK FULL MODEL
    @GetMapping("/snacks/{id}")
    public Snack getSnackById(@PathVariable Long id) throws Exception;


    @DeleteMapping("/snacks/{id}")
    public void deleteSnackId(@PathVariable Long id) throws Exception;

    // EDIT OR CREATE FULL SMACK
    @PutMapping("/snacks/{id}")
    public void updateSnack(@PathVariable Long id,  @RequestBody Snack snack) throws Exception ;

    @PostMapping("/snacks")
    public void createNewSnack(@RequestBody Snack snack);




}
