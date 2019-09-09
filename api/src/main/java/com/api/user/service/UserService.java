package com.api.user.service;

import com.api.user.pojo.User;

import java.util.concurrent.Future;

public interface UserService {

    Future<String> insert1();
    Future<String> insert2();
    Future<String> insert3();
}
