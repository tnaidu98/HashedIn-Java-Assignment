package com.hashkart.user.service.impl;

import com.hashkart.user.JwtUtil;
import com.hashkart.user.common.LoginUser;
import com.hashkart.user.entities.User;
import com.hashkart.user.repositories.UserRepository;
import com.hashkart.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtUtil jwtUtil;

    @Override
    public String saveUser(LoginUser user) {
        User newUser = new User();
        newUser.setUserName(user.getUserName());
        newUser.setPassword(user.getPassword());
        userRepository.save(newUser);
        return "User Added Successfully";

    }

    @Override
    public String loginUser(LoginUser user) {

        User userDetails = userRepository.findByUserName(user.getUserName());

        if(userDetails == null)
            return "Incorrect Credentials";

        if(user.getPassword().equals(userDetails.getPassword())) {

            final String jwt = jwtUtil.createToken(user.getUserName());
            return jwt;
        }
        else {
            return "Wrong Password";
        }

    }

}
