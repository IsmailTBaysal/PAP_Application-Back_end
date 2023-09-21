package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.persistence.*;

@Entity
@Table(name = "country", schema = "pap_test_schema_002")
public class Country {

    //Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "code", nullable = false, length = 10)
    @JsonProperty("code_n")
    @JsonSerialize(using = ToStringSerializer.class)
    private String code;


    //Constructors
    public Country() {

    }

    public Country(String name, String code) {

        this.name = name;
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


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }



    @Override
    public String toString() {
        return "Country [id=" + id + ", name =" + name + ", code =" + code + "]";
    }

}