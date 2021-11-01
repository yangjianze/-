package com.example.demo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("stgrade")
@Data
public class Stgrade {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer studentid;
    private String name;
    private Integer grade;
    private Integer classid;
    private Integer dormitoryid;
    private String createtime;
    private String updatetime;
}
