package com.travel.travelagency.repo.model;

import javax.persistence.*;

@Entity
@Table(name = "trips")
public final class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String country;
    private String city;
    private String description;
    private Integer price;

    public Trip(){
    }

    public Trip(String country, String city, String description, Integer price) {
        this.country = country;
        this.city = city;
        this.description = description;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public void setCounty(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }



}
