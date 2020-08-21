package com.apartmentsonline.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;
@Entity
@Table(name = "apartment")
public class Apartment {
    @Id
    @Type(type = "pg-uuid")
    @Column(name = "apartment_id")
    private UUID id;

    @Type(type = "pg-uuid")
    @Column(name = "user_id")
    private UUID userID;

    @Column(name = "num_beds")
    private int numBeds;

    @Column(name = "num_baths")
    private int numBaths;

    @Column(name = "address")
    private String address;

    @Column(name = "area")
    private double area;

    @Column(name = "img_url")
    private String imgURL;

    @Column(name = "price")
    private double price;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Amenities amenities;

    @Column(name = "util_details")
    private String utilDetails;

    @Column(name = "restrictions")
    private String restrictions;

    public Apartment() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public int getNumBeds() {
        return numBeds;
    }

    public void setNumBeds(int numBeds) {
        this.numBeds = numBeds;
    }

    public int getNumBaths() {
        return numBaths;
    }

    public void setNumBaths(int numBaths) {
        this.numBaths = numBaths;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Amenities getAmenities() {
        return amenities;
    }

    public void setAmenities(Amenities amenities) {
        this.amenities = amenities;
    }

    public String getUtilDetails() {
        return utilDetails;
    }

    public void setUtilDetails(String utilDetails) {
        this.utilDetails = utilDetails;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }
}
