package com.turkcelltry.springbootlibrary.controller;

import com.turkcelltry.springbootlibrary.country.Country;
import com.turkcelltry.springbootlibrary.service.CountryServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/")
public class CountryController {
    @Autowired
    CountryServiceImplementation countryServiceImplementation;

    @GetMapping("/countries")
    private List<Country> getAllCountries(){
        return countryServiceImplementation.getAll();
    }
    @PostMapping("/saveCountry")
    private ResponseEntity<Country> saveCountries(@Validated @RequestBody(required = true) Country country){
        System.out.println("Entered!");
        countryServiceImplementation.save(country);
        return ResponseEntity.ok(country);
    }


    @GetMapping("/countries/{id}")
    private Country getCountry(@PathVariable("id")String id){
         return countryServiceImplementation.getById(id);
    }


    @PostMapping("/deleteCountry/{id}")
    private ResponseEntity<String> deleteCountry(@PathVariable("id")String id){
        System.out.println("Entered here!");
         countryServiceImplementation.delete(id);
         return ResponseEntity.ok(id);
    }

    @PostMapping("/updateCountry/{id}")
    private String updateCountry(@PathVariable("id") String id,  @RequestBody Country country){
        System.out.println(country.getModify_user());
         countryServiceImplementation.update(country, String.valueOf(id));
         return "Updated!";
    }
}
