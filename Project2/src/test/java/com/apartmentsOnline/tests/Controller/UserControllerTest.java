package com.apartmentsOnline.tests.Controller;

import com.apartmentsOnline.tests.DAO.TestConfig;
import com.apartmentsonline.Controllers.UserController;
import com.apartmentsonline.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@ContextConfiguration(classes = TestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {
    @Autowired
    WebApplicationContext wac;

    @Autowired
    UserController testController;

    private MockMvc mvc;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @After
    public void tearDown() throws Exception{

    }

    @Test
    public void contextLoads() {}

    @Test
    public void PostToUserController_registeringNewUser_thenReturn() throws Exception {
        User me = new User();
        ObjectMapper om = new ObjectMapper();
        me.setEmail("email@domain.com");
        me.setFullName("First and last");
        me.setPassword("password1234");
        String json = om.writeValueAsString(me);
        MvcResult result = mvc.perform(post("/user/register")
                .contentType("application/json").content(json))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();
        User test = testController.getUserService().getUserByEmail(me.getEmail());
        Assert.assertNotNull(result);
        Assert.assertTrue("something's not right", result.getResponse().getStatus() == 201);
        User remove = testController.getUserService().getUserByEmail("email@domain.com");
        testController.getUserService().removeUser(remove);
    }


    @Test
    public void PostToUserController_loginUser_thenReturn() throws Exception {
        User me = testController.getUserService().getUserByEmail("a@a.com");
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(me);
        MvcResult result = mvc.perform(post("/user/login")
                .contentType("application/json").content(json))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        Assert.assertNotNull(result);
        Assert.assertTrue("something's not right", result.getResponse().getStatus() == 200);
    }

    @Test
    public void getUserById_FromUserController_thenReturnResponse() throws Exception {
        MvcResult result = mvc.perform(get("/user/f11ec008-e9da-46de-bc8e-f0864c3e05a1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        Assert.assertNotNull(result);
        Assert.assertTrue("something's not right", result.getResponse().getStatus() == 200);
    }

//    @Test
//    public void updateUser_FromUserController_thenReturnResponse() throws Exception {
//        User updateMe = new User();
//        ObjectMapper om = new ObjectMapper();
//        updateMe.setId(UUID.fromString("f11ec008-e9da-46de-bc8e-f0864c3e05a1"));
//        updateMe.setEmail("g@g.com");
//        updateMe.setFullName("This G");
//        updateMe.setPassword("thisisg");
//        String json = om.writeValueAsString(updateMe);
//        MvcResult result = mvc.perform(put("/user/updateUser")
//                .contentType("application/json").content(json))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andReturn();
//        User test = testController.getUserService().getUserByEmail(updateMe.getEmail());
//        Assert.assertNotNull(result);
//        Assert.assertTrue("something's not right", result.getResponse().getStatus() == 200);
//
//    }
}
