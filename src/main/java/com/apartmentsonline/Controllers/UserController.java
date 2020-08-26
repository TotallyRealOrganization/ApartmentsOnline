package com.apartmentsonline.Controllers;

import com.apartmentsonline.Services.UserService;
import com.apartmentsonline.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.awt.*;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // get user by id
    @GetMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<User> getUserById(@PathVariable("userId") String id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

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

    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<User> userLogin(@RequestBody User user) {
        User use = userService.getUserByEmail(user.getEmail());
        if (use != null && use.getEmail().equals(user.getEmail()) && use.getPassword().equals(user.getPassword()))
            return new ResponseEntity<>(use, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }


}
