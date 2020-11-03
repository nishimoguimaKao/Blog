package com.yhp.service.impl;

import com.yhp.dao.UserRepository;
import com.yhp.po.User;
import com.yhp.service.UserService;
import com.yhp.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user=userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));//防止明码在网上传输密码
        return user;
    }
}
