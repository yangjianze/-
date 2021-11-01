package com.example.demo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("comment")
@Data
public class Comment {
    @TableId(type = IdType.AUTO)
    private  Integer id;
    private  String name;
    private String txt;
    private  String createtime;
    private  Integer bid;

}
