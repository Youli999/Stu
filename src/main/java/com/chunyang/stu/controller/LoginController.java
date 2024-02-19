package com.chunyang.stu.controller;

import com.chunyang.stu.api.Result;
import com.chunyang.stu.api.ResultCode;
import com.chunyang.stu.pojo.User;
import com.chunyang.stu.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.chunyang.stu.util.JwtUtils;


@RestController
public class LoginController {

    Logger logger= Logger.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @PostMapping("login")
    Result<Map> Login(@RequestParam  String username,String password) {

        Map map = new HashMap<>();

        User user = userService.login(username,password);
        if (user != null ){

            String token = JwtUtils.createToken(user.getUsername(), "stu", 300);

            map.put("token",token);

            return Result.success(map);
        }else {

            return Result.failure(ResultCode.NOT_LOGIN);

        }

    }

}
