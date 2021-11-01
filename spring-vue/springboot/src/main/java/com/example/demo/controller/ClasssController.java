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
import com.example.demo.mapper.ClassMapper;
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
@RequestMapping("/classs")
@CrossOrigin
public class ClasssController {
    @Resource
    ClassMapper classMapper;

    @PostMapping//新增
    public Result<?> save(@RequestBody Classs classs){
        classMapper.insert(classs);
        return Result.success();
    }

    @PutMapping//修改
    public Result<?> update(@RequestBody Classs classs){
        classMapper.updateById(classs);
        return Result.success();
    }

    @DeleteMapping("/{id}")//删除
    public Result<?> delete(@PathVariable Long id){
        classMapper.deleteById(id);
        return Result.success();
    }

    @PostMapping("/deleteBatch")//批量删除
    public Result<?> deleteBatch(@RequestBody List<Integer> ids){
        classMapper.deleteBatchIds(ids);
        return  Result.success();
    }

    @GetMapping//查询
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search){
        LambdaQueryWrapper<Classs> wrapper = Wrappers.<Classs>lambdaQuery();
        if (StrUtil.isNotBlank(search)){
            wrapper.like(Classs::getClassid,search);
        }
        Page<Classs> userPage = classMapper.selectPage(new Page<>(pageNum,pageSize),wrapper);
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
        List<Classs> all = classMapper.selectList(null);
        for (Classs classs : all) {
            Map<String, Object> row1 = new LinkedHashMap<>();
//            row1.put("编号", classs.getId());
            row1.put("班级编号", classs.getClassid());
            row1.put("班级名", classs.getClassname());
            row1.put("辅导员", classs.getCounsellor());
            list.add(row1);
        }
        // 2. 写 excel
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(list, true);
        response.setContentType("application/vnd.openxmlformatsofficedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("班级列表", "UTF-8");
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
        List<Classs> saveList = new ArrayList<>();
        for (List<Object> row : lists) {
            Classs classs = new Classs();
//            classs.setId(row.get(0).toString());
            classs.setClassid(new Integer(row.get(0).toString()));
            classs.setClassname(row.get(1).toString());
            classs.setCounsellor(row.get(2).toString());
            saveList.add(classs);
        }
        for (Classs user : saveList) {
            classMapper.insert(user);
        }
        return Result.success();
    }
}
