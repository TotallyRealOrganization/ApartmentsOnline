package com.apartmentsonline.models;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;
@Entity
@Table(name = "amenities")
public class Amenities {
    @Id
    @Type(type = "pg-uuid")
    @Column(name = "amenities_id")
    private UUID id;

    @Type(type = "pg-uuid")
    @Column(name = "apartment_id")
    private UUID apartmentID;

    @Column(name = "washer_dryer")
    private boolean washerDryer;

    @Column(name = "air_conditioning")
    private boolean airConditioning;

    @Column(name = "furniture")
    private boolean furniture;

    @Column(name = "dishwasher")
    private boolean dishwasher;

    @Column(name = "balcony")
    private boolean balcony;

    @Column(name = "fitness")
    private boolean fitness;

    @Column(name = "indoor_parking")
    private boolean indoorParking;

    public Amenities(UUID apartmentID, boolean washerDryer, boolean airConditioning, boolean furniture, boolean dishwasher, boolean balcony, boolean fitness, boolean indoorParking) {
        this.id = UUID.randomUUID();
        this.apartmentID = apartmentID;
        this.washerDryer = washerDryer;
        this.airConditioning = airConditioning;
        this.furniture = furniture;
        this.dishwasher = dishwasher;
        this.balcony = balcony;
        this.fitness = fitness;
        this.indoorParking = indoorParking;
    }

    public Amenities() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public UUID getApartmentID() {
        return apartmentID;
    }

    public void setApartmentID(UUID apartmentID) {
        this.apartmentID = apartmentID;
    }

    public boolean isWasherDryer() {
        return washerDryer;
    }

    public void setWasherDryer(boolean washerDryer) {
        this.washerDryer = washerDryer;
    }

    public boolean isAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    public boolean isFurniture() {
        return furniture;
    }

    public void setFurniture(boolean furniture) {
        this.furniture = furniture;
    }

    public boolean isDishwasher() {
        return dishwasher;
    }

    public void setDishwasher(boolean dishwasher) {
        this.dishwasher = dishwasher;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public boolean isFitness() {
        return fitness;
    }

    public void setFitness(boolean fitness) {
        this.fitness = fitness;
    }

    public boolean isIndoorParking() {
        return indoorParking;
    }

    public void setIndoorParking(boolean indoorParking) {
        this.indoorParking = indoorParking;
    }
}
