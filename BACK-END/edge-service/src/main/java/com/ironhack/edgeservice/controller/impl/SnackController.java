package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.model.Snack;
import com.ironhack.edgeservice.service.impl.SnackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@CrossOrigin(value = "http://localhost:4200")
public class SnackController {

    @Autowired
    private SnackService snackService;

    // ALL SNACKS
    @GetMapping("/snacks")
    @ResponseStatus(HttpStatus.OK)
    public List<Snack> getAllSnacks(){

        return snackService.getAllSnacks();
    }



    // ONE SNACK FULL MODEL
    @GetMapping("/snacks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Snack getSnackById(@PathVariable Long id) throws Exception {
        return snackService.getSnackById(id);
    }





    @DeleteMapping("/snacks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSnackId(@PathVariable Long id) throws Exception {
        snackService.deleteSnack(id);
    }


    // EDIT OR CREATE FULL SMACK
    @PutMapping("/snacks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateSnack(@PathVariable Long id,  @RequestBody Snack snack) throws Exception {

        snackService.updateSnack(id, snack);
    }

    @PostMapping("/snacks")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewSnack(@RequestBody Snack snack){

        snackService.createNewSnack(snack);
    }


}
