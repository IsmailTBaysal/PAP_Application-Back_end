package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user", schema = "pap_test_schema_002")
public class User {

    //Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name", nullable = true)
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

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "country_id", nullable = false)
    private int countryId;

    @Column(name = "role_id", nullable = false)
    private int roleId;

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
    public User() {

    }

    public User(String firstName, String middleName, String lastName, String mobilePhone, String workPhone, String homePhone, String email, String password, int countryId, int roleId, short statusId, String createdOn, Long createdBy, String modifiedOn, Long modifiedBy, Long rowVersion) {

        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.mobilePhone = mobilePhone;
        this.workPhone = workPhone;
        this.homePhone = homePhone;
        this.email = email;
        this.password = password;
        this.countryId = countryId;
        this.roleId = roleId;
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

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getcountryId() {
        return countryId;
    }
    public void setcountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getroleId() {
        return roleId;
    }
    public void setroleId(int roleId) {
        this.roleId = roleId;
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






    @Override
    public String toString() {
        return "User [id=" + id + ", fname=" + firstName + ", mname=" + middleName + ", lname=" + lastName
                + ", phone=" + mobilePhone + ", email=" + email + ", password=" + password
                + ", countryid=" + countryId + ", roleid=" + roleId + ", statusid=" + statusId
                + ", createdon=" + createdOn + ", createdby=" + createdBy
                + ", modifiedon=" + modifiedOn + ", modifiedby=" + modifiedBy
                + ", rowversion=" + rowVersion + "]";
    }

}