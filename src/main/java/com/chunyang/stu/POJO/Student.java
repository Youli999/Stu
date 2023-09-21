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
@TableName("student")
public class Student {

    //用户ID
    private  Integer Id;

    private  String  name;

    private  Integer age;

    private  String sex;



}