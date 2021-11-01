package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import lombok.Data;

import java.util.List;

@TableName("admins")
@Data
public class Admin {
    @TableId(type = IdType.AUTO)
    private  Integer id;
    private  String  username;
    private  String  password;
    private  String  name;
    private  Integer phone;
    private  Integer power;
//    private  String  describes;
}
