package com.apartmentsonline.Controllers;

import com.apartmentsonline.Services.ApartmentService;
import com.apartmentsonline.models.Apartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/apartment")
public class ApartmentController {

    private ApartmentService apartmentService;

    @Autowired
    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    // get apartments by apartmentId
    @GetMapping(path="/{apartmentId}", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public ResponseEntity<List<Apartment>> getById(@PathVariable("apartmentId") String apartmendId) {
        List<Apartment> apartments = new ArrayList<Apartment>();
        Apartment apartment = apartmentService.getById(apartmendId);
        apartments.add(apartment);
        return new ResponseEntity<List<Apartment>>(apartments, HttpStatus.OK);
    }

    // save apartment
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> saveApartment(@RequestBody Apartment apartment) {
        boolean savedApartment = apartmentService.saveApartment(apartment);
        return ResponseEntity.ok().body("Apartment saved: " + savedApartment);
    }

}
