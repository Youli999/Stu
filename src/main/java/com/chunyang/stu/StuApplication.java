package com.chunyang.stu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.chunyang.stu.Mapping")
public class StuApplication {

    public static void main(String[] args) {
        SpringApplication.run(StuApplication.class, args);
    }

}
