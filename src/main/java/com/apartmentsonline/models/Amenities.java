package com.apartmentsonline.models;

import java.util.UUID;

public class Amenities {
    private UUID id;
    private boolean washerDryer;
    private boolean airConditioning;
    private boolean furniture;
    private boolean dishwasher;
    private boolean balcony;
    private boolean fitness;
    private boolean indoorParking;

    public Amenities() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
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
