package com.apartmentsonline.Services;

import com.apartmentsonline.DAO.UserDAO;
import com.apartmentsonline.models.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserService {

    private UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean saveNewUser(User user) {
        User use = userDAO.saveNewUser(user);
        if (use != null)
            return true;
        return false;
    }

    public User getUserById(String id) {
        if (id != null)
            return userDAO.getUserById(id);
        return null;
    }

    public boolean removeUser(User u) {
       return userDAO.removeUser(u);
    }
}
