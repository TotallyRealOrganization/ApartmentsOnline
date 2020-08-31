package com.apartmentsonline.Controllers;

import com.apartmentsonline.Services.UserService;
import com.apartmentsonline.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.awt.*;

@EnableSwagger2
@CrossOrigin("*")
@Controller
@RequestMapping(path = "/user")
/***
 * Controller class that will handle requests sent by the dispatcher servlet.
 * Uses a userService to fulfil the requests and implement the business logic.
 */
public class UserController {

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    /***
     * Gets spring to inject our userService object to be readily available for use.
     * @param userService the service needed by the UserController
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // get user by id

    /***
     * finds a User based on the ID passed in through the URL
     * @param id the id passed in the URL
     * @return a User object wrapped in a ResponseEntity for the front-end to ork with
     */
    @GetMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<User> getUserById(@PathVariable("userId") String id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /***
     * Registers a new User to the DB in PostgreSQL
     * @param user the JSON representation of a User to be registered with the DB
     * @return User object that was just created if successful and a 401 http status if failure
     */
    @PostMapping( path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<User> saveNewUser(@RequestBody User user) {
        boolean u = userService.saveNewUser(user);
        if (u)
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        else  {
            return new ResponseEntity<>( HttpStatus.valueOf(401));
        }

    }

    /***
     *  logs an existing user into the system making sure the provided username and password math the User that exists in the DB
     * @param user the JSON representation of a User to be logged into the system
     * @return User object that was logged in if successful or a HttpStatus bad request if authentication failed
     */
    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<User> userLogin(@RequestBody User user) {
        User use = userService.getUserByEmail(user.getEmail());
        if (use != null && use.getEmail().equals(user.getEmail()) && use.getPassword().equals(user.getPassword()))
            return new ResponseEntity<>(use, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

//    /***
//     * updates an existing user's information
//     * @param user the JSON representation of the updated User
//     * @return the newly updated User if successful or a bad request if failure
//     */
//    @PutMapping(path = "/updateUser",consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public ResponseEntity<User> updateUser(@RequestBody User user) {
//        User user1 = userService.updateUser(user);
//        return new ResponseEntity<>(user1,HttpStatus.OK);
//    }

}
