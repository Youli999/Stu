package com.chunyang.stu.service;

import com.chunyang.stu.pojo.User;

import java.util.List;

public interface UserService {
    List<User> finduser(Integer id);


    User selectById(Long id);
}