package com.pfm.user_service.dao;

import com.pfm.user_service.model.User;

import java.util.List;

public interface UserServiceDao {
    User createUser(User u);

    User getUserById(long id);

    User getUserByEmailId(String emailId);

    List<User> findAllUser();

    User updateUserInfo(User user);
}
