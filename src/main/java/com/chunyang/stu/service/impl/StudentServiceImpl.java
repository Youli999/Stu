package com.chunyang.stu.service.impl;

import com.chunyang.stu.mapping.StudentMapper;
import com.chunyang.stu.pojo.Student;
import com.chunyang.stu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public  Student findStudentById(Long id) {

        Student student = studentMapper.selectById(id);

        return  student;

    }
}
