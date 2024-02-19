package com.chunyang.stu;

import com.chunyang.stu.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class TestJDBC {

    @Autowired
    private UserService userService;


    //test jdbc conntion

   @Test
   void TestJDBC(){
       String url = "jdbc:mysql://localhost:3306/stu";
       String username = "root";
       String password = "root";

       try (Connection connection = DriverManager.getConnection(url, username, password)) {
           System.out.println("MySQL database connected successfully!");
       } catch (SQLException e) {
           System.err.println("Failed to connect to MySQL database!");
           e.printStackTrace();
       }

    }



    @Test
    void TestUser(){


    }

}
