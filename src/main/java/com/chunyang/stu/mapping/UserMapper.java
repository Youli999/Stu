package com.chunyang.stu.mapping;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chunyang.stu.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper extends BaseMapper<User> {


    List<User> finduser(Integer id);

    //    通过名称密码检测是否存在用户
    User existuser(String username,String password);





}
