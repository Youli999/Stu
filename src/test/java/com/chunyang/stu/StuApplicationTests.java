package com.chunyang.stu;

import com.chunyang.stu.Mapping.StudentMapper;
import com.chunyang.stu.POJO.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StuApplicationTests {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    void contextLoads() {

        Student student = studentMapper.selectById(1);


        System.out.println(student);
    }

}
