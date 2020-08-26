package com.apartmentsonline.Services;

import com.apartmentsonline.DAO.ApartmentDAO;
import com.apartmentsonline.models.Apartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ApartmentService {

    private ApartmentDAO apartmentDAO;

    @Autowired
    public ApartmentService(ApartmentDAO apartmentDAO) {
        this.apartmentDAO = apartmentDAO;
    }

    // get apartments by apartmentId
    @Transactional
    public Apartment getById(String apartmentId) {
        return apartmentDAO.getById(apartmentId);
    }

    @Transactional
    public boolean saveApartment(Apartment newApartment) {
        return apartmentDAO.saveApartment(newApartment);
    }

    @Transactional
    public boolean removeApartment(Apartment apartment) {
        return apartmentDAO.removeApartment(apartment);
    }

}
