package com.pfm.user_service.dao.impl;

import com.pfm.user_service.dao.UserRepository;
import com.pfm.user_service.dao.UserServiceDao;
import com.pfm.user_service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserServiceDaoImpl implements UserServiceDao {

    @Autowired
    private UserRepository userRepository;

    /** ---------- CREATE USER ---------- **/
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /** ---------- GET USER BY ID ---------- **/
    @Override
    public User getUserById(long id) {
        return userRepository.findById(id)
                .orElse(null);   // return null if not found
    }

    /** ---------- GET USER BY EMAIL ---------- **/
    @Override
    public User getUserByEmailId(String emailId) {
        return userRepository.getUserByEmailId(emailId);
    }

    /** ---------- GET ALL USERS ---------- **/
    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    /** ---------- UPDATE USER ---------- **/
    @Override
    public User updateUserInfo(User user) {
        return userRepository.save(user); // save() works for update also
    }
}
