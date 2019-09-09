package com.api.user.service.impl;

import com.api.user.mapper.UserMapper;
import com.api.user.pojo.User;
import com.api.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;



    @Override
    @Async
    public Future<String> insert1() {
        System.out.println("任务一开始....");
        long start = System.currentTimeMillis();
        User user = new User();
        user.setUsername("张13");
        user.setPwd("123456");
        user.setStatus((byte) 2);
        add(user);
        System.out.println("任务一结束...., 耗时："+(System.currentTimeMillis() - start));
        return new AsyncResult<>("任务一完成");
    }

    @Override
    @Async
    public Future<String> insert2() {
        System.out.println("任务二开始....");
        long start = System.currentTimeMillis();
        User user = new User();
        user.setUsername("张14");
        user.setPwd("123456");
        user.setStatus((byte) 2);
        add(user);
        System.out.println("任务二结束.... 耗时："+(System.currentTimeMillis() - start));
        return new AsyncResult<>("任务二完成");
    }

    @Override
    @Async
    public Future<String> insert3() {
        System.out.println("任务三开始....");
        long start = System.currentTimeMillis();
        User user = new User();
        user.setUsername("张15");
        user.setPwd("123456");
        user.setStatus((byte) 2);
        add(user);
        System.out.println("任务三结束....  耗时："+(System.currentTimeMillis() - start));
        return new AsyncResult<>("任务三完成");
    }

    public boolean add(User user) {
        userMapper.insert(user);
        return true;
    }
}
