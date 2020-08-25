package com.apartmentsOnline.tests.DAO;

import com.apartmentsonline.DAO.ApartmentDAO;
import com.apartmentsonline.models.Amenities;
import com.apartmentsonline.models.Apartment;
import com.apartmentsonline.models.ORMConfig;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class ApartmentDAOTest {

    @Autowired
    private ApartmentDAO test;


    private Apartment aptToBeAdded;

    @Before
    public void setUp() {
        aptToBeAdded = new Apartment();
        aptToBeAdded.setAddress("123Dummy Test Blvd.");
        aptToBeAdded.setAmenities(new Amenities(null,true,true,true,true,true,true,true));
    }

    @Test
    @Transactional
    public void saveApartment_thenReturn() {
        Assert.assertTrue(test.saveApartment(aptToBeAdded));
    }

    @Test
    public void getAllApartments() {
        Assert.assertNotNull(test.getAllApartments());
    }

    @Test
    public void getById() {
        Assert.assertNotNull(test.getById("88e347da-6072-49f8-8c95-b71bb77d0f1f"));
    }
}
