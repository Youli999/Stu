package com.chunyang.stu.POJO;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("user")
public class User {
    //用户ID
    private  Integer Id;
    // 用户名称
    private  String  username;
    // 用户密码
    private  String password;
    // 用户登入账号
    private  Integer phoneNumber;


}
