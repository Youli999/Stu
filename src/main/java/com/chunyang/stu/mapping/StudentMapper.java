package com.chunyang.stu.mapping;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chunyang.stu.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {


}
