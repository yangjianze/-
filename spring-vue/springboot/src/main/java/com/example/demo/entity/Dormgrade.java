package com.example.demo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("dormgrade")
@Data
public class Dormgrade {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer dormitoryid;
    private String dormbuilding;
    private Integer grade;
    private String createtime;
    private String updatetime;
}
