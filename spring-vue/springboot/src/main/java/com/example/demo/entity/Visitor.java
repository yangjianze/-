package com.example.demo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("visitor")
@Data
public class Visitor {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer phone;
    private Integer dormitoryid;
    private String dormbuilding;
    private String createtime;

}
