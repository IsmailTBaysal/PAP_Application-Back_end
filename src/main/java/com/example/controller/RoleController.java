package com.example.controller;

import com.example.model.Role;
import com.example.model.User;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/api/v1/role")
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/all")
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }


    @GetMapping("/searchby/name/{name}")
    public ResponseEntity<?> getRolesByName(@PathVariable(value = "name") String name) {

        List<Role> roles = roleRepository.findByName(name);

        if (roles.isEmpty()){
            String message = "No roles found with name: " + name;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }

        return ResponseEntity.ok(roles);
    }


    @GetMapping("/searchby/id/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable(value = "id") Long roleId)
            throws ResourceNotFoundException {
        Role user = roleRepository.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found for this id: " + roleId));
        return ResponseEntity.ok().body(user);
    }


}