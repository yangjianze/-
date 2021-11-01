package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Blogs;

public interface BlogsMapper extends BaseMapper<Blogs> {
    //一对多查询
    Page<Blogs> findPage(Page<Blogs> page);
}
