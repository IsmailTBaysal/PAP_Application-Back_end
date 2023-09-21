package com.example.repository;

import com.example.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    List<User> findByfirstNameIgnoreCase(String firstName);

    List<User> findBylastNameIgnoreCase(String lastName);
}