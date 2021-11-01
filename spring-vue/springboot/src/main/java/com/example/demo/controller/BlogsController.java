package com.example.demo.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.Blogs;
import com.example.demo.entity.Classs;
import com.example.demo.mapper.BlogsMapper;
import com.example.demo.mapper.ClassMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/blogs")
public class BlogsController {
    @Resource
    BlogsMapper blogsMapper;

//    @PostMapping("/write")//新增
//    public Result<?> write(@RequestBody Blogs blogs) throws IOException {
//        //获取当前日期时间
//        blogs.setCreatetime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
////        blogsMapper.insert(blogs);
//        //使用uuid确保唯一性
//        UUID uuid = UUID.randomUUID();
//        //获取当前工程路径
//        String path = System.getProperty("user.dir");
//        //拼接路径名
//        String paths=path+"/springboot/target/classes/com/example/demo/"+uuid;
//        //创建一个FileWriter文件，如果不存在则自动创建
//        FileWriter fr =new FileWriter(paths+".txt");
//        //把文章写入文件
//        fr.write(blogs.getContent());
//        //3.关闭close流
//        fr.close();
//        blogs.setPath(paths+".txt");
//        blogs.setContent("");
//        blogsMapper.insert(blogs);
//        return Result.success();
//    }


    @PostMapping//新增
    public Result<?> save(@RequestBody Blogs blogs){
        blogs.setCreatetime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        blogsMapper.insert(blogs);
        return Result.success();
    }

    @PutMapping//修改
    public Result<?> update(@RequestBody Blogs blogs){
        blogsMapper.updateById(blogs);
        return Result.success();
    }

    @DeleteMapping("/{id}")//删除
    public Result<?> delete(@PathVariable Long id){
        blogsMapper.deleteById(id);
        return Result.success();
    }

    @GetMapping//查询
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search){
        LambdaQueryWrapper<Blogs> wrapper = Wrappers.<Blogs>lambdaQuery();
        if (StrUtil.isNotBlank(search)){
            wrapper.like(Blogs::getAuthor,search);
        }
        Page<Blogs> userPage = blogsMapper.selectPage(new Page<>(pageNum,pageSize),wrapper);
        //一对多
//        Page<Blogs> userPage = blogsMapper.findPage(new Page<>(pageNum,pageSize));
        return Result.success(userPage);
    }

//    @GetMapping("/read")//查询
//    public Result<?> read(@RequestParam(defaultValue = "") Integer pageNum,
//                              @RequestParam(defaultValue = "") Integer pageSize,
//                              @RequestParam(defaultValue = "") String search) throws IOException {
//        LambdaQueryWrapper<Blogs> wrapper = Wrappers.<Blogs>lambdaQuery();
//        if (StrUtil.isNotBlank(search)){
//            wrapper.like(Blogs::getAuthor,search);
//        }
//        Page<Blogs> userPage = blogsMapper.selectPage(new Page<>(pageNum,pageSize),wrapper);
//
//        // 1.创建一个FileReader文件 文件名不存在
//        FileReader fd = new FileReader("a.txt");
//        // 2.读出文件
//        System.out.print("读取第一个字:");
//        int gg = fd.read();
//        System.out.println(gg);
//        //每次使用就读取下一次
//        int hh;
//        System.out.print("读取剩余全部:");
//        while ((hh = fd.read()) != -1) {
//            System.out.print((char)hh+" ");
//        }
//        // 3.关闭close流
//        fd.close();
//
//        return Result.success(userPage);
//    }
}
