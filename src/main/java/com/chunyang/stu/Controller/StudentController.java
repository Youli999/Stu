package com.chunyang.stu.Controller;



import com.chunyang.stu.POJO.Student;
import com.chunyang.stu.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("findStudentById")
    Student findStudentById(@RequestParam Long id){


        Student studentById = studentService.findStudentById(id);

       return studentById;

    }
}
