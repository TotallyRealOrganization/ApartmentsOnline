package com.apartmentsOnline.tests.DAO;

import com.apartmentsonline.models.Amenities;
import com.apartmentsonline.models.Apartment;
import org.junit.Before;

public class ApartmentDAO {
    private ApartmentDAO test;
    private Apartment aptToBeAdded;

    @Before
    public void setUp() {
        aptToBeAdded = new Apartment();
        aptToBeAdded.setAddress("123Dummy Test Blvd.");
        aptToBeAdded.setAmenities(new Amenities(null,true,true,true,true,true,true,true));
    }
}
