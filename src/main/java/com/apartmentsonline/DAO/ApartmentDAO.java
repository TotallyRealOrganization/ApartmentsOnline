package com.apartmentsonline.DAO;

import com.apartmentsonline.models.Apartment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


import java.util.UUID;
@Repository
@Transactional
public class ApartmentDAO {
    private SessionFactory sf;
    @Autowired
    public ApartmentDAO(SessionFactory sf) {
        this.sf = sf;
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Apartment saveApartment(Apartment newApartment) {
        Session sesh = sf.getCurrentSession();
        sesh.save(newApartment);
    return newApartment;
    }
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Apartment getById(String apartmentId) {
        UUID uuid = UUID.fromString(apartmentId);
        Session sesh = sf.getCurrentSession();
        Apartment apartment = (Apartment) sesh.get(Apartment.class, uuid);
        return apartment;
    }



}
