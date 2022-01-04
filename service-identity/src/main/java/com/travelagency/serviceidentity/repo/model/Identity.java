package com.travelagency.serviceidentity.repo.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public final class Identity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstname;
    private String lastname;
    private String email;
    private String telNumber;
    private Integer age;
    private String password;

    public Identity() { }

    public Identity(String firstname, String lastname, String email, String telNumber, Integer age, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.telNumber = telNumber;
        this.age = age;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
