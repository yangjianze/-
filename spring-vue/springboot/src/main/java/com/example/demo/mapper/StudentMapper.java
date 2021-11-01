package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.*;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper extends BaseMapper<Student> {
    @Select("select count(id) count,classid from student group by classid")
    List<StudentClassid> countclassid();

    @Select("select count(dormitoryid) count,dormitoryid from student group by dormitoryid")
    List<StudentDormitoryid> countdormitoryid();

    @Select("select count(classname) count,classname from student group by classname")
    List<StudentClassname> countclassname();
}
