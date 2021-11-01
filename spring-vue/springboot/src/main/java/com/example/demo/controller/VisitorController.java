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
import com.example.demo.entity.Dormgrade;
import com.example.demo.entity.User;
import com.example.demo.entity.Visitor;
import com.example.demo.mapper.UserMapper;
import com.example.demo.mapper.VisitorMapper;
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
@RequestMapping("/visitor")
public class VisitorController {
    @Resource
    VisitorMapper visitorMapper;

    @PostMapping
    public Result<?> save(@RequestBody Visitor visitor){
        visitorMapper.insert(visitor);
        return Result.success();
    }

    @PutMapping
    public Result<?> update(@RequestBody Visitor visitor){
        visitorMapper.updateById(visitor);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id){
        visitorMapper.deleteById(id);
        return Result.success();
    }

    @PostMapping("/deleteBatch")//批量删除
    public Result<?> deleteBatch(@RequestBody List<Integer> ids){
        visitorMapper.deleteBatchIds(ids);
        return  Result.success();
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search){
        LambdaQueryWrapper<Visitor> wrapper = Wrappers.<Visitor>lambdaQuery();
        if (StrUtil.isNotBlank(search)){
            wrapper.like(Visitor::getName,search);
        }
        Page<Visitor> userPage = visitorMapper.selectPage(new Page<>(pageNum,pageSize),wrapper);
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
        List<Visitor> all = visitorMapper.selectList(null);
        for (Visitor visitor : all) {
            Map<String, Object> row1 = new LinkedHashMap<>();
//            row1.put("编号", student.getId());
            row1.put("访客姓名", visitor.getName());
            row1.put("访客电话", visitor.getPhone());
            row1.put("访问宿舍编号", visitor.getDormitoryid());
            row1.put("访问宿舍楼", visitor.getDormbuilding());
            row1.put("访问时间", visitor.getCreatetime());
            list.add(row1);
        }
        // 2. 写 excel
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(list, true);
        response.setContentType("application/vnd.openxmlformatsofficedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("访问列表", "UTF-8");
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
        List<Visitor> saveList = new ArrayList<>();
        for (List<Object> row : lists) {
            Visitor visitor = new Visitor();
//            classs.setId(row.get(0).toString());
            visitor.setName(row.get(0).toString());
            visitor.setPhone(new Integer(row.get(1).toString()));
            visitor.setDormitoryid(new Integer(row.get(2).toString()));
            visitor.setDormbuilding(row.get(3).toString());
            visitor.setCreatetime(row.get(4).toString());
            saveList.add(visitor);
        }
        for (Visitor visitor : saveList) {
            visitorMapper.insert(visitor);
        }
        return Result.success();
    }
}
