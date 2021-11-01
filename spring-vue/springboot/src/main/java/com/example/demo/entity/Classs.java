package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;
@TableName("class")
@Data
public class Classs {
    @TableId(type = IdType.AUTO)
    private  Integer id;
    private  Integer classid;
    private  String  classname;
    private  String  counsellor;
    //班级与学生为一对多关系，使用链表
//    private List<Student>  students;

}
