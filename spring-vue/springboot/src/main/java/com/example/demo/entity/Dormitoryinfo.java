package com.example.demo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("dormitoryinfo")
@Data
public class Dormitoryinfo {
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private  Integer id;
    private  Integer dormitoryid;
    private  String  dormbuilding;
    private  String  bedtotal;
    private  String  bed;
    private  String  name;
}
