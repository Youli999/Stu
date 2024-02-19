package com.chunyang.stu.service.impl;

import com.chunyang.stu.mapping.UserMapper;
import com.chunyang.stu.pojo.User;
import com.chunyang.stu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> finduser(Integer id) {
        List<User> finduser = userMapper.finduser(id);
        return finduser;
    }

    @Override
    public User selectById(Long id) {

        User user = userMapper.selectById(id);

        return user;
    }

    @Override
    public User login(String username, String password) {

        User user = userMapper.existuser(username,password);

        return user;
    }


}
