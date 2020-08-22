package com.apartmentsonline.Controllers;

import com.apartmentsonline.Services.ApartmentService;
import com.apartmentsonline.models.Apartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/apartment")
public class ApartmentController {

    private ApartmentService apartmentService;

    @Autowired
    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    // get apartments by apartmentId
    @GetMapping(path="{apartmentId}", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public ResponseEntity<Apartment> getById(@PathVariable("apartmentId") String apartmendId) {
        Apartment apartment = apartmentService.getById(apartmendId);
        System.out.println("aparment controller found");
        return ResponseEntity.ok().body(apartment);
    }

}
