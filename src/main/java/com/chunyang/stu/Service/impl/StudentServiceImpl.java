package com.chunyang.stu.Service.impl;

import com.chunyang.stu.Mapping.StudentMapper;
import com.chunyang.stu.POJO.Student;
import com.chunyang.stu.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
