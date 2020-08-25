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

    public User saveNewUser(User user) {
        return userDAO.saveNewUser(user);
    }

    public User getUserById(String id) {
        return userDAO.getUserById(id);
    }

    public boolean removeUser(User u) {
       return userDAO.removeUser(u);
    }
}
