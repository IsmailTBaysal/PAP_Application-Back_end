package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "state", schema = "pap_test_schema_002")
public class State {

    //Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "state", nullable = false, length = 50)
    private String state;

    @Column(name = "code", nullable = false, length = 3)
    private String code;

    //Constructors
    public State() {

    }

    public State(String state, String code) {

        this.state = state;
        this.code = code;
    }


    //Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }


    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }



    @Override
    public String toString() {
        return "Role [id=" + id + ", state =" + state + ", code =" + code + "]";
    }

}