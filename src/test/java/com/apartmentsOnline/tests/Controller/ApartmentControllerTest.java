package com.apartmentsOnline.tests.Controller;


import com.apartmentsonline.Controllers.ApartmentController;
import com.apartmentsonline.models.Apartment;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/test-applicaion-context.xml"})
@WebAppConfiguration
public class ApartmentControllerTest {

    @Autowired
    WebApplicationContext wac;

    @Autowired
    ApartmentController aptController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void getById() throws Exception {
        MvcResult result = mockMvc.perform(get("/apartment/cd84627d-0c73-485e-a28b-c1e4cd7a8f95"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        Assert.assertNotNull(result);
        Assert.assertTrue("Empty content",result.getResponse().getContentAsString().length()>0);
    }

    @Test
    public void getAllApartments() throws Exception {
        MvcResult result = mockMvc.perform(get("/apartment/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        Assert.assertNotNull(result);
        Assert.assertTrue("Empty content",result.getResponse().getContentAsString().length()>0);
    }

    @Test
    public void saveAndRemoveNewApt() throws Exception {
        Apartment apartment = new Apartment();
        apartment.setId(UUID.fromString("9005fad9-6858-4065-a092-dfde1c5d5f6d"));
        apartment.setAddress("1 Test Controller Way");
        apartment.setArea(3289.32);
        apartment.setNumBaths(55);
        apartment.setNumBeds(54);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonContent = objectMapper.writeValueAsString(apartment);
        MvcResult result = mockMvc.perform(post("/apartment")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jsonContent))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();
        Assert.assertNotNull(result);
        Assert.assertTrue("something's not right",result.getResponse().getStatus()==201);
        Apartment removeTestApt = aptController.getApartmentService().getById(apartment.getId().toString());
        Assert.assertTrue(aptController.getApartmentService().removeApartment(removeTestApt));
    }
}
