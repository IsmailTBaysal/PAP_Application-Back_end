package com.example.controller;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.HashMap;
import java.util.Map;


import org.springframework.http.ResponseEntity;


@RestController
@CrossOrigin
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/count")
    public ResponseEntity<?> getUsersCount() {

        Long count = userRepository.count();

        int c = count.intValue();
        String message = "";
        message += "User count is: " + c;

        if (c <= 0){
            message = "No users";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }


    @GetMapping("/searchby/fname/{name}")
    public ResponseEntity<?> getUsersByFirstName(@PathVariable(value = "name") String firstName) {

        List<User> users = userRepository.findByfirstNameIgnoreCase(firstName);

        if (users.isEmpty()){
            String message = "No users found with first name: " + firstName;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }

        return ResponseEntity.ok(users);
    }


    @GetMapping("/searchby/lname/{name}")
    public ResponseEntity<?> getUsersByLastName(@PathVariable(value = "name") String lastName) {

        List<User> users = userRepository.findBylastNameIgnoreCase(lastName);

        if (users.isEmpty()){
            String message = "No users found with last name: " + lastName;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }

        return ResponseEntity.ok(users);
    }


    @GetMapping("/searchby/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id: " + userId));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/add")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        User savedUser = userRepository.save(user);
        return ResponseEntity.created(null).body(savedUser);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
                                               @RequestBody User userDetails) throws ResourceNotFoundException {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id: " + userId));

        user.setfirstName(userDetails.getfirstName());
        user.setmiddleName(userDetails.getmiddleName());
        user.setlastName(userDetails.getlastName());
        user.setmobilePhone(userDetails.getmobilePhone());
        user.setworkPhone(userDetails.getworkPhone());
        user.sethomePhone(userDetails.gethomePhone());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setcountryId(userDetails.getcountryId());
        user.setroleId(userDetails.getroleId());
        user.setstatusId(userDetails.getstatusId());
        user.setcreatedOn(userDetails.getcreatedOn());
        user.setcreatedBy(userDetails.getcreatedBy());
        user.setmodifiedOn(userDetails.getmodifiedOn());
        user.setmodifiedBy(userDetails.getmodifiedBy());
        user.setrowVersion(userDetails.getrowVersion());

        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id: " + userId));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted user: " + userId, Boolean.TRUE);
        return response;
    }
}