package com.hashkart.user.service;

import com.hashkart.user.common.LoginUser;
import com.hashkart.user.entities.User;

public interface UserService {
    public String saveUser(LoginUser user);

    public String loginUser(LoginUser user);
}
