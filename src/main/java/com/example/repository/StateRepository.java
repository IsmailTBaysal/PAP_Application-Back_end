package com.example.repository;

import com.example.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<State, Long>{
    List<State> findByState(String state);

    List<State> findByCode(String code);
}