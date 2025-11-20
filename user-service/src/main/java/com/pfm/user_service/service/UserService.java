package com.pfm.user_service.service;

import com.pfm.user_service.model.User;
import com.pfm.user_service.model.dto.LoginDto;
import com.pfm.user_service.model.dto.UserDto;

import java.util.List;

public interface UserService {
    User createUser(UserDto user);

    User getUserById(long id);

    LoginDto userLogin(LoginDto user);

    List<User> findAllUser();

    User updateUserInfo(long id ,UserDto userDto);
}
