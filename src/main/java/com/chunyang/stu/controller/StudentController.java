package com.chunyang.stu.controller;



import com.chunyang.stu.api.Result;
import com.chunyang.stu.pojo.Student;
import com.chunyang.stu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("api/findStudentById")
    Result<Student> findStudentById(@RequestParam Long id){


        Student studentById = studentService.findStudentById(id);

       return Result.success(studentById);

    }
}
