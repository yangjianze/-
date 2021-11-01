package com.example.demo.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.Classs;
import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    @Resource
    StudentMapper studentMapper;

    @PostMapping//新增
    public Result<?> save(@RequestBody Student student){
        studentMapper.insert(student);
        return Result.success();
    }

    @PutMapping//修改
    public Result<?> update(@RequestBody Student student){
        studentMapper.updateById(student);
        return Result.success();
    }

    @DeleteMapping("/{id}")//删除
    public Result<?> delete(@PathVariable Long id){
        studentMapper.deleteById(id);
        return Result.success();
    }

    @PostMapping("/deleteBatch")//批量删除
    public Result<?> deleteBatch(@RequestBody List<Integer> ids){
        studentMapper.deleteBatchIds(ids);
        return  Result.success();
    }

    @GetMapping//查询
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search){
        LambdaQueryWrapper<Student> wrapper = Wrappers.<Student>lambdaQuery();
        if (StrUtil.isNotBlank(search)){
            wrapper.like(Student::getName,search);
        }
        Page<Student> userPage = studentMapper.selectPage(new Page<>(pageNum,pageSize),wrapper);
        return Result.success(userPage);
    }

    /**
     * Excel 导出
     * @param response
     * @throws IOException
     */
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = CollUtil.newArrayList();
        List<Student> all = studentMapper.selectList(null);
        for (Student student : all) {
            Map<String, Object> row1 = new LinkedHashMap<>();
//            row1.put("编号", student.getId());
            row1.put("学生编号", student.getStudentid());
            row1.put("姓名", student.getName());
            row1.put("性别", student.getSex());
            row1.put("年龄", student.getAge());
            row1.put("电话", student.getPhone());
            row1.put("班级号", student.getClassid());
            row1.put("班级名", student.getClassname());
            row1.put("宿舍号", student.getDormitoryid());
            list.add(row1);
        }
        // 2. 写 excel
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(list, true);
        response.setContentType("application/vnd.openxmlformatsofficedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("学生信息", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");
        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        writer.close();
        IoUtil.close(System.out);
    }

    /**
     * Excel 导入
     * 导入的模板可以使用 Excel 导出的文件
     * @param file Excel
     * @return
     * @throws IOException
     */
    @PostMapping("/import")
    public Result<?> upload( @RequestParam("file") MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        List<List<Object>> lists = ExcelUtil.getReader(inputStream).read(1);
        List<Student> saveList = new ArrayList<>();
        for (List<Object> row : lists) {
            Student student = new Student();
//            classs.setId(row.get(0).toString());
            student.setStudentid(new Integer(row.get(0).toString()));
            student.setName(row.get(1).toString());
            student.setSex(row.get(2).toString());
            student.setAge(new Integer(row.get(3).toString()));
            student.setPhone(new Integer(row.get(4).toString()));
            student.setClassid(new Integer(row.get(5).toString()));
            student.setClassname(row.get(6).toString());
            student.setDormitoryid(new Integer(row.get(7).toString()));
            saveList.add(student);
        }
        for (Student student : saveList) {
            studentMapper.insert(student);
        }
        return Result.success();
    }

    @GetMapping("/count")
    public Result<?> count(){
        return Result.success(studentMapper.countclassid());
    }

    @GetMapping("/count2")
    public Result<?> count2(){
        return Result.success(studentMapper.countdormitoryid());
    }

    @GetMapping("/count3")
    public Result<?> count3(){
        return Result.success(studentMapper.countclassname());
    }
}
