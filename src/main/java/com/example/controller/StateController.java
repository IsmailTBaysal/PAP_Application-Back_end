package com.example.controller;


import com.example.model.State;
import com.example.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/v1/state")
public class StateController {
    @Autowired
    private StateRepository stateRepository;

    @GetMapping("/all")
    public List<State> getAllStates() {
        return stateRepository.findAll();
    }


    @GetMapping("/searchby/state/{state}")
    public ResponseEntity<?> getStateByState(@PathVariable(value = "state") String state) {

        List<State> states = stateRepository.findByState(state);

        if (states.isEmpty()){
            String message = "No states found with name: " + state;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }

        return ResponseEntity.ok(states);
    }

    @GetMapping("/searchby/code/{code}")
    public ResponseEntity<?> getStateByCode(@PathVariable(value = "code") String code) {

        List<State> states = stateRepository.findByCode(code);

        if (states.isEmpty()){
            String message = "No states found with code: " + code;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }

        return ResponseEntity.ok(states);
    }


    @GetMapping("/searchby/id/{id}")
    public ResponseEntity<State> getRoleById(@PathVariable(value = "id") Long Id)
            throws ResourceNotFoundException {
        State state = stateRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found for this id: " + Id));
        return ResponseEntity.ok().body(state);
    }


}