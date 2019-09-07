package com.api;

import com.api.user.pojo.User;
import com.api.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreedTest {
    @Autowired
    private UserService userService;

    @Test
    public void test() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                User user = new User();
                user.setUsername("张5");
                user.setPwd("123");
                user.setStatus((byte) 9);
                userService.insert(user);
            }
        });

        thread1.start();
    }

    @Test
    public void test2() {
        User user = new User();
        user.setUsername("张sg");
        user.setPwd("123");
        user.setStatus((byte) 6);
        userService.insert(user);
    }
}
