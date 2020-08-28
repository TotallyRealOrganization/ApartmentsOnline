package com.apartmentsonline.DAO;

import com.apartmentsonline.models.Apartment;
import com.apartmentsonline.models.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
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
    public boolean saveApartment(Apartment newApartment) {
        try {
            Session sesh = sf.getCurrentSession();
            sesh.save(newApartment);
            sesh.flush();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Apartment getById(String apartmentId) {
        UUID uuid = UUID.fromString(apartmentId);
        Session sesh = sf.getCurrentSession();
        Apartment apartment = (Apartment) sesh.get(Apartment.class, uuid);
        return apartment;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public List<Apartment> getAllApartments() {
        Session sesh = sf.getCurrentSession();
        String hql = "from Apartment";
        Query query = sesh.createQuery(hql);
        List<Apartment> apartments = (List<Apartment>) query.list();
        if (apartments.size() <= 0)
            return null;
        return apartments;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public boolean removeApartment(Apartment apartment) {
        Session sesh = sf.getCurrentSession();
        sesh.delete(apartment);
        return true;
    }


}
