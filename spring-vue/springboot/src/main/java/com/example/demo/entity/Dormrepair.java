package com.example.demo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("dormrepair")
@Data
public class Dormrepair {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer dormitoryid;
    private String dormbuilding;
    private String name;
    private String reason;
    private String createtime;
    private String updatetime;
}
