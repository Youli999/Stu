package com.chunyang.stu.Mapping;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chunyang.stu.POJO.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface UserMapper extends BaseMapper<User> {


    List<User> finduser(Integer id);

    //    通过名称密码检测是否存在用户
    User existuser(String username,String password);


}
