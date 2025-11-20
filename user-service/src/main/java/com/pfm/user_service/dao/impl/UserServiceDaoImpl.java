package com.pfm.user_service.dao.impl;

import com.pfm.user_service.dao.UserRepository;
import com.pfm.user_service.dao.UserServiceDao;
import com.pfm.user_service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserServiceDaoImpl implements UserServiceDao {

    @Autowired
    UserRepository userRepository;
    @Override
    public boolean createUser(User u) {
        boolean resp = false;
        try {
            userRepository.save(u);
            return true;

        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public User getUserById(long id) {

        Optional<User> responce = userRepository.findById(id);
        return responce.get();
    }

    @Override
    public User getUserByEmailId(String emailId) {
       User resp= userRepository.getUserByEmailId(emailId);
        return resp;
    }

    @Override
    public List<User> findAllUser() {
        List<User> listUserRecord = userRepository.findAll();
        return listUserRecord;
    }

    @Override
    public User updateUserInfo(User user) {

        return userRepository.save(user);
    }
}
