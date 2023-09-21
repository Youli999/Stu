package com.chunyang.stu.Service;

import com.chunyang.stu.POJO.User;

import java.util.List;

public interface UserService {
    List<User> finduser(Integer id);


    User selectById(Long id);
}