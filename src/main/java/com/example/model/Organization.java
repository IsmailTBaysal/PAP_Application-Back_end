package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "organization", schema = "pap_test_schema_002")
public class Organization {

    //Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address_1", nullable = true)
    private String address1;

    @Column(name = "address_2", nullable = true)
    private String address2;

    @Column(name = "address_3", nullable = true)
    private String address3;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name", nullable = false)
    private String middleName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "mobile_phone", nullable = false)
    private String mobilePhone;

    @Column(name = "work_phone", nullable = false)
    private String workPhone;

    @Column(name = "home_phone", nullable = false)
    private String homePhone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "country_id", nullable = false)
    private int countryId;

    @Column(name = "state_id", nullable = false)
    private Long stateId;

    @Column(name = "status_id", nullable = false)
    private short statusId;

    @Column(name = "created_on", nullable = false)
    private String createdOn;

    @Column(name = "created_by", nullable = false)
    private Long createdBy;

    @Column(name = "modified_on", nullable = false)
    private String modifiedOn;

    @Column(name = "modified_by", nullable = false)
    private Long modifiedBy;

    @Column(name = "row_version", nullable = false)
    private Long rowVersion;

    //Constructors
    public Organization() {

    }

    public Organization(String name, String address1, String address2, String address3, String city, String postalCode, String firstName, String middleName, String lastName, String mobilePhone, String workPhone, String homePhone, String email, int countryId, Long stateId, short statusId, String createdOn, Long createdBy, String modifiedOn, Long modifiedBy, Long rowVersion) {

        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.city = city;
        this.postalCode = postalCode;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.mobilePhone = mobilePhone;
        this.workPhone = workPhone;
        this.homePhone = homePhone;
        this.email = email;
        this.countryId = countryId;
        this.stateId = stateId;
        this.statusId = statusId;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.modifiedOn = modifiedOn;
        this.modifiedBy = modifiedBy;
        this.rowVersion = rowVersion;

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

    public String getAddress1() {
        return address1;
    }
    public void setAddress1(String address1) {
        this.address1 = address1;
    }


    public String getAddress2() {
        return address2;
    }
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }
    public void setAddress3(String address3) {
        this.address3 = address3;
    }



    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getpostalCode() {
        return postalCode;
    }
    public void setpostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getfirstName() {
        return firstName;
    }
    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getmiddleName() {
        return middleName;
    }
    public void setmiddleName(String middleName) {
        this.middleName = middleName;
    }


    public String getlastName() {
        return lastName;
    }
    public void setlastName(String lastName) {
        this.lastName = lastName;
    }


    public String getmobilePhone() { return mobilePhone; }
    public void setmobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getworkPhone() { return workPhone; }
    public void setworkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String gethomePhone() { return homePhone; }
    public void sethomePhone(String homePhone) {
        this.homePhone = homePhone;
    }



    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getcountryId() {
        return countryId;
    }
    public void setcountryId(int countryId) {
        this.countryId = countryId;
    }

    public Long getstateId() {
        return stateId;
    }
    public void setstateId(Long stateId) {
        this.stateId = stateId;
    }

    public short getstatusId() {
        return statusId;
    }
    public void setstatusId(short statusId) {
        this.statusId = statusId;
    }

    public String getcreatedOn() {
        return createdOn;
    }
    public void setcreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public Long getcreatedBy() {
        return createdBy;
    }
    public void setcreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public String getmodifiedOn() {
        return modifiedOn;
    }
    public void setmodifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Long getmodifiedBy() {
        return modifiedBy;
    }
    public void setmodifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Long getrowVersion() {
        return rowVersion;
    }
    public void setrowVersion(Long rowVersion) {
        this.rowVersion = rowVersion;
    }


}