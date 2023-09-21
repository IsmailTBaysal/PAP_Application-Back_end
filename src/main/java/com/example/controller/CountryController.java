package com.example.controller;

import com.example.model.Country;
import com.example.model.Role;
import com.example.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/v1/country")
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/all")
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }


    @GetMapping("/searchby/name/{name}")
    public ResponseEntity<?> getCountriesByName(@PathVariable(value = "name") String name) {

        List<Country> countries = countryRepository.findByName(name);

        if (countries.isEmpty()){
            String message = "No countries found with name: " + name;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }

        return ResponseEntity.ok(countries);
    }

    @GetMapping("/searchby/code/{code}")
    public ResponseEntity<?> getCountriesByCode(@PathVariable(value = "code") String code) {

        List<Country> countries = countryRepository.findByCode(code);

        if (countries.isEmpty()){
            String message = "No countries found with code: " + code;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }

        return ResponseEntity.ok(countries);
    }


    @GetMapping("/searchby/id/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found for this id: " + id));
        return ResponseEntity.ok().body(country);
    }


}