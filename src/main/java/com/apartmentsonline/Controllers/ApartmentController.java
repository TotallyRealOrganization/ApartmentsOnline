package com.apartmentsonline.Controllers;

import com.apartmentsonline.Services.ApartmentService;
import com.apartmentsonline.models.Apartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(path = "/apartment")
public class ApartmentController {

    private ApartmentService apartmentService;

    public ApartmentService getApartmentService() {
        return apartmentService;
    }

    @Autowired
    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    // get apartments by apartmentId
    @GetMapping(path="/{apartmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Apartment> getById(@PathVariable("apartmentId") String apartmendId) {
        Apartment apartment = apartmentService.getById(apartmendId);
        return new ResponseEntity<>(apartment, HttpStatus.OK);
    }

    @GetMapping(path="/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Apartment>> getAllApartments() {
        List<Apartment> allApartments = apartmentService.getAllApartments();
        return new ResponseEntity<>(allApartments,HttpStatus.OK);
    }

    // save apartment
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Apartment> saveApartment(@RequestBody Apartment apartment) {
        boolean savedApartment = apartmentService.saveApartment(apartment);
        if(savedApartment) {
            return new ResponseEntity<>(apartment,HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.valueOf(401));
        }
    }

}
