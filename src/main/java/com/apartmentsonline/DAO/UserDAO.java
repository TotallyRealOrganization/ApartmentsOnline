package com.apartmentsonline.DAO;

import com.apartmentsonline.models.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
@Transactional
public class UserDAO {
    private SessionFactory sf;
    @Autowired
    public UserDAO(SessionFactory sf) {
        this.sf = sf;
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public User saveNewUser(User user) {
        Session sesh = sf.getCurrentSession();
        sesh.save(user);
        return user;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public User getUserById(String id) {
        UUID uuid = UUID.fromString(id);
        Session sesh = sf.getCurrentSession();
        User u = (User) sesh.get(User.class, uuid);
        if (u != null)
            return u;
        return null;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public User getUserByEmail(String email) {
        Session sesh = sf.getCurrentSession();
        Criteria criteria = sesh.createCriteria(User.class);
        User u = (User) criteria.add(Restrictions.eq("email", email)).uniqueResult();
        if (u != null)
            return u;
        return null;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public boolean removeUser(User u) {
        Session sesh = sf.getCurrentSession();
        sesh.delete(u);
        return true;
    }
}
