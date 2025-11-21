package com.pfm.user_service.service.impl;

import com.pfm.user_service.dao.UserServiceDao;
import com.pfm.user_service.model.User;
import com.pfm.user_service.model.dto.LoginDto;
import com.pfm.user_service.model.dto.UserDto;
import com.pfm.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserServiceDao userServiceDao;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * ------------------ CREATE USER ------------------
     **/
    @Override
    public User createUser(UserDto dto) {

        // check duplicate email
        User existing = userServiceDao.getUserByEmailId(dto.getEmailId());
        if (existing != null) {
            throw new RuntimeException("Email already registered.");
        }

        User u = new User();
        u.setEmailId(dto.getEmailId());
        u.setFirstName(dto.getFirstName());
        u.setLastName(dto.getLastName());
        u.setMobileNo(dto.getMobileNo());
        u.setPassword(passwordEncoder.encode(dto.getPassword())); // hashed password

        return userServiceDao.createUser(u);
    }

    /** ------------------ GET USER BY ID ------------------ **/
    @Override
    public User getUserById(long id) {
        User user = userServiceDao.getUserById(id);
        if (user == null) {
            throw new RuntimeException("User not found with ID: " + id);
        }
        return user;
    }

    /** ------------------ LOGIN ------------------ **/
    @Override
    public LoginDto userLogin(LoginDto userDto) {
        LoginDto response = new LoginDto();
        User user = userServiceDao.getUserByEmailId(userDto.getEmailId());

        if (user == null) {
            response.setCode(HttpStatus.NOT_FOUND.value());
            response.setMessages("Email not registered.");
            return response;
        }

        if (passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
            response.setCode(HttpStatus.OK.value());
            response.setMessages("Login Successful.");
        } else {
            response.setCode(HttpStatus.UNAUTHORIZED.value());
            response.setMessages("Invalid email or password.");
        }

        return response;
    }

    /** ------------------ GET ALL USERS ------------------ **/
    @Override
    public List<User> findAllUser() {
        return userServiceDao.findAllUser();
    }

    /** ------------------ UPDATE USER ------------------ **/
    @Override
    public User updateUserInfo(long id, UserDto dto) {
        User user = userServiceDao.getUserById(id);
        if (user == null) {
            throw new RuntimeException("User not found with ID: " + id);
        }

        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setMobileNo(dto.getMobileNo());
        user.setEmailId(dto.getEmailId());

        // update password only if new password provided
        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        return userServiceDao.updateUserInfo(user);
    }
}
