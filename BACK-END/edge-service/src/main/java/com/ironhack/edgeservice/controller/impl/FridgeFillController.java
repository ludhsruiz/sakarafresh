package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.model.FridgeFill;
import com.ironhack.edgeservice.service.impl.FridgeFillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
public class FridgeFillController {

    @Autowired
    private FridgeFillService fridgeFillService;


    @GetMapping("/fridge-fills")
    @ResponseStatus(HttpStatus.OK)
    public List<FridgeFill> getAllFridgeFills(){
        return fridgeFillService.getAllFridgeFill();
    }



    // ONE FRIDGE FILL  FULL MODEL
    @GetMapping("/fridge-fills/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FridgeFill getFridgeFillById(@PathVariable Long id) throws Exception {
        return fridgeFillService.getFridgeFillById(id);
    }



    @DeleteMapping("/fridge-fills/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFridgeFillId(@PathVariable Long id) throws Exception {
        fridgeFillService.deleteFridgeFill(id);
    }


    // EDIT OR CREATE FULL SMACK
    @PutMapping("/fridge-fills/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateFridgeFill(@PathVariable Long id,  @RequestBody FridgeFill fridgeFill) throws Exception {
          fridgeFillService.updateFridgeFill(id, fridgeFill);
    }

    @PostMapping("/fridge-fills")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewFridgeFill(@RequestBody FridgeFill fridgeFill){

        fridgeFillService.createNewFridgeFill(fridgeFill);
    }
}
