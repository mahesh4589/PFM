package com.pfm.user_service.controller;

import com.pfm.user_service.model.User;
import com.pfm.user_service.model.dto.LoginDto;
import com.pfm.user_service.model.dto.UserDto;
import com.pfm.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users/")
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    ResponseEntity<LoginDto> userLogin(@Validated @RequestBody LoginDto user)
    {
        LoginDto resp = userService.userLogin(user);
        if(resp != null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(resp);
        }else
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
        }
    }
}
