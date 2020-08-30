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

@CrossOrigin
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

    /***
     * get apartment by id
     * @param apartmendId - this is being extracted from the url
     * @return it returns the apartment object and httpstatus.ok if successful, otherwise nothing is returned
     */
    @GetMapping(path="/{apartmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Apartment> getById(@PathVariable("apartmentId") String apartmendId) {
        Apartment apartment = apartmentService.getById(apartmendId);
        return new ResponseEntity<>(apartment, HttpStatus.OK);
    }

    /***
     * get all apartments
     * @return returns a list of apartments which is iterated through in the frontend
     */
    @GetMapping(path="/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Apartment>> getAllApartments() {
        List<Apartment> allApartments = apartmentService.getAllApartments();
        return new ResponseEntity<>(allApartments,HttpStatus.OK);
    }

    /***
     * save a new apartment
     * @param apartment an apartment is sent in the request bodu in json format
     * @return the apartment is sent back along with a 201 status, otherwise a client error of 401
     */
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
