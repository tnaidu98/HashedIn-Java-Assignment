package com.hashkart.user.controllers;

import com.hashkart.user.common.LoginUser;
import com.hashkart.user.entities.User;
import com.hashkart.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> saveUser(@RequestBody LoginUser user){
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginUser user){
        return new ResponseEntity<>(userService.loginUser(user), HttpStatus.OK);
    }

}
