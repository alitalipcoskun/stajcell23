package com.turkcelltry.springbootlibrary.controller;

import com.turkcelltry.springbootlibrary.product.Tax;
import com.turkcelltry.springbootlibrary.service.TaxServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/")
public class TaxController {
    @Autowired
    TaxServiceImplementation taxtServiceImplementation;

    @GetMapping("/taxes")
    private List<Tax> getAllTaxes(){
        return taxtServiceImplementation.getAll();
    }
    @PostMapping("/saveTax")
    private ResponseEntity<Tax> saveProduct(@Validated @RequestBody(required = true) Tax tax){
        System.out.println("Entered!");
        System.out.println(tax.getId());
        taxtServiceImplementation.save(tax);
        return ResponseEntity.ok(tax);
    }


    @GetMapping("/taxes/{id}")
    private Tax getTax(@PathVariable("id")String id){
         return taxtServiceImplementation.getById(id);
    }


    @PostMapping("/deleteTax/{id}")
    private ResponseEntity<String> deleteProduct(@PathVariable("id")String id){
        System.out.println("Entered here!");
         taxtServiceImplementation.delete(id);
         return ResponseEntity.ok(id);
    }

    @PostMapping("/updateTax/{id}")
    private String updateTax(@PathVariable("id") String id,  @RequestBody Tax tax){
        System.out.println(tax.getModify_user());
         taxtServiceImplementation.update(tax, String.valueOf(id));
         return "Updated!";
    }
}
