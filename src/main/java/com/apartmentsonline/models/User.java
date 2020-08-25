package com.apartmentsonline.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;
@Entity
@Table(name = "users")
public class User {
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "pword")
    private String password;

    @Id
    @Type(type = "pg-uuid")
    @Column(name = "user_id")
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "id")
    private Set<Apartment> listedApartments;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "id")
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
