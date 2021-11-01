package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("student")
@Data
public class StudentClassname {
    private  Integer count;
    private  String classname;
}
