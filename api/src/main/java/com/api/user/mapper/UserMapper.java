package com.api.user.mapper;

import com.api.user.pojo.User;
import org.apache.ibatis.annotations.Insert;

public interface UserMapper {

    @Insert("INSERT INTO user(username, pwd, status) VALUES(#{username}, #{pwd}, #{status})")
    void insert(User user);
}
