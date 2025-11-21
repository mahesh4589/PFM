package com.pfm.user_service.controller;

import com.pfm.user_service.model.User;
import com.pfm.user_service.model.dto.UserDto;
import com.pfm.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static jakarta.ws.rs.core.Response.status;

@RestController
@RequestMapping("/api/users/")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/user")
    ResponseEntity<User> createUser(@RequestBody UserDto user) {
        User resp = userService.createUser(user);
        if (resp != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(resp);
        } else {
            return (ResponseEntity<User>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/{id}")
    ResponseEntity<User> getUserById(@PathVariable("id") long id )
    {
        User resp = userService.getUserById(id);
        if(resp != null)
        {
            return  ResponseEntity.status(HttpStatus.OK).body(resp);
        }else
        {
            return (ResponseEntity<User>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    ResponseEntity<List<User>> findAllUser() {
        List<User> listUser = userService.findAllUser();
        if (listUser != null) {
           return  ResponseEntity.status(HttpStatus.OK).body(listUser);
        } else {
            return (ResponseEntity<List<User>>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    ResponseEntity<User> updateUserInfo(@PathVariable("id") long id, @RequestBody UserDto userDto )
    {
        User user = userService.updateUserInfo(id,userDto);
        if(user !=null)
        {
            return  ResponseEntity.status(HttpStatus.OK).body(user);
        }else {
            return (ResponseEntity<User>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }

    }
}
