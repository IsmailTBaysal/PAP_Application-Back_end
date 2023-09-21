package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "role", schema = "pap_test_schema_002")
public class Role {

    //Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    //Constructors
    public Role() {

    }

    public Role(String name) {

        this.name = name;

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


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Role [id=" + id + ", name =" + name + "]";
    }

}