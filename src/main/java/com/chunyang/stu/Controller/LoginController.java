package com.chunyang.stu.Controller;

import com.chunyang.stu.POJO.User;
import com.chunyang.stu.Service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {

    Logger logger= Logger.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @PostMapping("login")
    List<User> Login(@RequestParam Integer id) {

        List<User> users = userService.finduser(id);

        return users;

    }

    @PostMapping("selectById")
        User selectByid(@RequestParam Long id) {

        User user = userService.selectById(id);

        return user;

    }


    @PostMapping("show")
    User show(@RequestBody User user) {


     logger.info(user);
     logger.warn("this is warn message");

     return user;
    }

    @PostMapping("test")
    void test(@RequestParam String name,String sex) {


        logger.info(name +"-----" + sex);
        logger.warn("this is warn test");
    }

}
