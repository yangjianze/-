package com.example.demo.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;

import com.example.demo.entity.Admin;

import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import com.example.demo.mapper.AdminMapper;

import com.example.demo.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    AdminMapper adminMapper;

    @PostMapping//新增
    public Result<?> save(@RequestBody Admin admin){
        adminMapper.insert(admin);
        return Result.success();
    }

    @PutMapping//修改
    public Result<?> update(@RequestBody Admin admin){
        adminMapper.updateById(admin);
        return Result.success();
    }

    @DeleteMapping("/{id}")//删除
    public Result<?> delete(@PathVariable Long id){
        adminMapper.deleteById(id);
        return Result.success();
    }

    @GetMapping//查询
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search){
        //LambdaQueryWrapper是mybatis plus中的一个条件构造器对象，只是是需要使用Lambda 语法使用 Wrapper
        LambdaQueryWrapper<Admin> wrapper = Wrappers.<Admin>lambdaQuery();
        if (StrUtil.isNotBlank(search)){
            wrapper.like(Admin::getName,search);
        }
        Page<Admin> userPage = adminMapper.selectPage(new Page<>(pageNum,pageSize),wrapper);
        return Result.success(userPage);
    }

    @PostMapping("/login")//登录查询
    public Result<?> login(@RequestBody Admin admin){
        Admin res = adminMapper.selectOne(Wrappers.<Admin>lambdaQuery().eq(Admin::getUsername,admin.getUsername()).eq(Admin::getPassword,admin.getPassword()));
        if (res==null){
            return Result.error("-1","用户名或密码错误");
        }
        return Result.success(res);
    }

    @PostMapping("/reqister")//注册
    public Result<?> reqister(@RequestBody Admin admin){
        //是否存在用户名同名
        Admin res = adminMapper.selectOne(Wrappers.<Admin>lambdaQuery().eq(Admin::getUsername,admin.getUsername()));
        if (res!=null){
            return Result.error("-1","用户名已存在");
        }
        Admin res2 = adminMapper.selectOne(Wrappers.<Admin>lambdaQuery().eq(Admin::getName,admin.getName()));
        if (res2!=null){
            return Result.error("-1","姓名已存在");
        }
        if (admin.getPassword()==null||admin.getPassword()==""){
            admin.setPassword("123456");
        }
        adminMapper.insert(admin);
//        if (res==null){
//            return Result.error("-1","用户名或密码错误");
//        }
        return Result.success(res);
    }
}
