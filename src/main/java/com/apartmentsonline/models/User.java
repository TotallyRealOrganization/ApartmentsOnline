package com.apartmentsonline.models;

import java.util.Set;
import java.util.UUID;

public class User {
    private String email;
    private String fullName;
    private String password;
    private UUID id;
    private Set<Apartment> listedApartments;
    private Set<Apartment> savedApartments;

    public User() {
        this.id = UUID.randomUUID();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public Set<Apartment> getListedApartments() {
        return listedApartments;
    }

    public void setListedApartments(Set<Apartment> listedApartments) {
        this.listedApartments = listedApartments;
    }

    public Set<Apartment> getSavedApartments() {
        return savedApartments;
    }

    public void setSavedApartments(Set<Apartment> savedApartments) {
        this.savedApartments = savedApartments;
    }
}
