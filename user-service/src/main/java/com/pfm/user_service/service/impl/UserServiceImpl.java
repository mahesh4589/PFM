package com.pfm.user_service.service.impl;

import com.pfm.user_service.model.User;
import com.pfm.user_service.model.dto.LoginDto;
import com.pfm.user_service.model.dto.UserDto;
import com.pfm.user_service.service.UserService;
import com.pfm.user_service.dao.UserServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserServiceDao userServiceDao;

    @Override
    public User createUser(UserDto user) {
        User u = new User();
        u.setEmailId(user.getEmailId());
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setMobileNo(user.getMobileNo());
        u.setPassword(user.getPassword());
        boolean res = userServiceDao.createUser(u);
        if (res == true) {
            return u;
        } else

            return u;
    }

    @Override
    public User getUserById(long id) {
        return userServiceDao.getUserById(id);
    }

    @Override
    public LoginDto userLogin(LoginDto user) {
        User getRecord = userServiceDao.getUserByEmailId(user.getEmailId());
        LoginDto resp= new LoginDto();
        if(getRecord == null)
        {
            resp.setCode(HttpStatus.NOT_FOUND.value());
            resp.setMessages("Record Not Found ...!");
        }else if(getRecord.getEmailId().equals(user.getEmailId()) && getRecord.getPassword().equals(user.getPassword()))
        {
            resp.setCode(HttpStatus.OK.value());
            resp.setMessages("User Login Successfully ..!");
        }else {
            resp.setCode(HttpStatus.BAD_REQUEST.value());
            resp.setMessages("Username and Password is invalid..");
        }

        return resp;
    }

    @Override
    public List<User> findAllUser() {
       List< User> listUser = userServiceDao.findAllUser();
        return listUser;
    }

    @Override
    public User updateUserInfo(long id, UserDto userDto) {
        User user = userServiceDao.getUserById(id);
        if(user == null)
        {
            throw new RuntimeException("user not Found");
        }
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setMobileNo(userDto.getMobileNo());
        user.setEmailId(userDto.getEmailId());
        user.setPassword(userDto.getPassword());
        User updateuser =userServiceDao.updateUserInfo(user);
        return updateuser;
    }
}

