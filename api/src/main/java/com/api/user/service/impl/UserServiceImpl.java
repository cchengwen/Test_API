package com.api.user.service.impl;

import com.api.user.mapper.UserMapper;
import com.api.user.pojo.User;
import com.api.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public synchronized void insert(User user) {
        System.out.println(user);
        userMapper.insert(user);
    }
}
