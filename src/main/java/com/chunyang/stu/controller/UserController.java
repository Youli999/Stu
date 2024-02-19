package com.chunyang.stu.controller;

import com.chunyang.stu.api.Result;
import com.chunyang.stu.pojo.User;
import com.chunyang.stu.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    Logger logger= Logger.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @PostMapping("api/login")
    Result<List> Login(@RequestParam Integer id) {

        List<User> users = userService.finduser(id);

        return Result.success(users);

    }

    @PostMapping("api/selectById")
    Result<User> selectByid(@RequestParam Long id) {

        User user = userService.selectById(id);

        return Result.success(user);

    }


    @PostMapping("api/show")
    Result<User> show(@RequestBody User user) {


        logger.info(user);
        logger.warn("this is warn message");

        return Result.success(user);
    }

    @PostMapping("api/test")
    void test(@RequestParam String name,String sex) {


        logger.info(name +"-----" + sex);
        logger.warn("this is warn test");
    }

}
