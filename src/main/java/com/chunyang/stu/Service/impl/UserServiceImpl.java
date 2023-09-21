package com.chunyang.stu.Service.impl;

import com.chunyang.stu.Mapping.UserMapper;
import com.chunyang.stu.POJO.User;
import com.chunyang.stu.Service.UserService;
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


}
