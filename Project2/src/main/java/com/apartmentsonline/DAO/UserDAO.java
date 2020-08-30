package com.apartmentsonline.DAO;

import com.apartmentsonline.models.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
@Transactional
/***
 * DAO to perform CRUD operations on User objects
 */
public class UserDAO {
    private SessionFactory sf;
    private Logger logger = Logger.getLogger(UserDAO.class);
    // UserDAO requires a SessionFactory to be injected in
    @Autowired
    public UserDAO(SessionFactory sf) {
        this.sf = sf;
    }

    /***
     * Persist a User object to the DB
     * @param user the User object to be persisted
     * @return the User object that was successfully persisted
     */
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public User saveNewUser(User user) {
        Session sesh = sf.getCurrentSession();
        sesh.save(user);
        return user;
    }

    /***
     * Returns a persisted user object from the DB based on the ID provided
     * @param id the UUID that identifies the User
     * @return the User object that was located in the DB or null if User is null
     */
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public User getUserById(String id) {
        logger.info("We in this Bitch");
        UUID uuid = UUID.fromString(id);
        Session sesh = sf.getCurrentSession();
        User u = (User) sesh.get(User.class, uuid);
        if (u != null)
            return u;
        return null;
    }

    /***
     *  returns a persisted User object from DB based on the email provided
     * @param email the email String provided to search the DB for a user with a matching email
     * @return the User object that has the same email if found otherwise null
     */
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public User getUserByEmail(String email) {
        Session sesh = sf.getCurrentSession();
        Criteria criteria = sesh.createCriteria(User.class);
        User u = (User) criteria.add(Restrictions.eq("email", email)).uniqueResult();
        if (u != null)
            return u;
        return null;
    }

    /***
     * removes a given User object from the DB
     * @param u User object to be removed
     * @return true if the User was successfully removed and false otherwise
     */
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public boolean removeUser(User u) {
        Session sesh = sf.getCurrentSession();
        sesh.delete(u);
        return true;
    }

//    /***
//     * updates a persisted User
//     * @param user the user object that needs to be updated with new values
//     * @return the newly updated User object
//     */
//    @Transactional(isolation = Isolation.SERIALIZABLE)
//    public User updateUser(User user) {
//        Session session = sf.getCurrentSession();
//        session.update(user);
//        return user;
//    }
}
