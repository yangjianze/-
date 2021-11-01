package com.example.demo.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.Comment;
import com.example.demo.entity.Dormgrade;
import com.example.demo.mapper.CommentMapper;
import com.example.demo.mapper.DormgradeMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource
    CommentMapper commentMapper;

    @PostMapping//新增
    public Result<?> save(@RequestBody Comment comment){
        comment.setCreatetime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        commentMapper.insert(comment);
        return Result.success();
    }

    @PutMapping//修改
    public Result<?> update(@RequestBody Comment comment){
        commentMapper.updateById(comment);
        return Result.success();
    }

    @DeleteMapping("/{id}")//删除
    public Result<?> delete(@PathVariable Long id){
        commentMapper.deleteById(id);
        return Result.success();
    }

    @PostMapping("/deleteBatch")//批量删除
    public Result<?> deleteBatch(@RequestBody List<Integer> ids){
        commentMapper.deleteBatchIds(ids);
        return  Result.success();
    }

    @GetMapping//查询
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "10") Integer bid){
        LambdaQueryWrapper<Comment> wrapper = Wrappers.<Comment>lambdaQuery().eq(Comment::getBid,bid);
//        LambdaQueryWrapper<Comment> wrapper = Wrappers.<Comment>lambdaQuery();
//        if (StrUtil.isNotBlank(search)){
//            wrapper.like(Comment::getBid,search);
//        }
        Page<Comment> userPage = commentMapper.selectPage(new Page<>(pageNum,pageSize),wrapper);
        return Result.success(userPage);
    }



}
