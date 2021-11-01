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
import com.example.demo.entity.Dormitoryinfo;
import com.example.demo.entity.Dormrepair;
import com.example.demo.entity.Student;
import com.example.demo.mapper.DormitoryinfoMapper;
import com.example.demo.mapper.DormrepairMapper;
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
@RequestMapping("/dormrepair")
public class DormrepairController {
    @Resource
    DormrepairMapper dormrepairMapper;

    @PostMapping//新增
    public Result<?> save(@RequestBody Dormrepair dormrepair){
        dormrepairMapper.insert(dormrepair);
        return Result.success();
    }

    @PutMapping//修改
    public Result<?> update(@RequestBody Dormrepair dormrepair){
        dormrepairMapper.updateById(dormrepair);
        return Result.success();
    }

    @DeleteMapping("/{id}")//删除
    public Result<?> delete(@PathVariable Long id){
        dormrepairMapper.deleteById(id);
        return Result.success();
    }

    @PostMapping("/deleteBatch")//批量删除
    public Result<?> deleteBatch(@RequestBody List<Integer> ids){
        dormrepairMapper.deleteBatchIds(ids);
        return  Result.success();
    }

    @GetMapping//查询
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search){
        LambdaQueryWrapper<Dormrepair> wrapper = Wrappers.<Dormrepair>lambdaQuery();
        if (StrUtil.isNotBlank(search)){
            wrapper.like(Dormrepair::getName,search);
        }
        Page<Dormrepair> userPage = dormrepairMapper.selectPage(new Page<>(pageNum,pageSize),wrapper);
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
        List<Dormrepair> all = dormrepairMapper.selectList(null);
        for (Dormrepair dormrepair : all) {
            Map<String, Object> row1 = new LinkedHashMap<>();
//            row1.put("编号", student.getId());
            row1.put("宿舍编号", dormrepair.getDormitoryid());
            row1.put("宿舍楼", dormrepair.getDormbuilding());
            row1.put("维修人员", dormrepair.getName());
            row1.put("维修项目", dormrepair.getReason());
            row1.put("维修开始时间", dormrepair.getCreatetime());
            row1.put("维修结束时间", dormrepair.getUpdatetime());
            list.add(row1);
        }
        // 2. 写 excel
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(list, true);
        response.setContentType("application/vnd.openxmlformatsofficedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("维修登记", "UTF-8");
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
        List<Dormrepair> saveList = new ArrayList<>();
        for (List<Object> row : lists) {
            Dormrepair dormrepair = new Dormrepair();
//            classs.setId(row.get(0).toString());
            dormrepair.setDormitoryid(new Integer(row.get(0).toString()));
            dormrepair.setDormbuilding(row.get(1).toString());
            dormrepair.setName(row.get(2).toString());
            dormrepair.setReason(row.get(3).toString());
            dormrepair.setCreatetime(row.get(4).toString());
            dormrepair.setUpdatetime(row.get(5).toString());
            saveList.add(dormrepair);
        }
        for (Dormrepair dormrepair : saveList) {
            dormrepairMapper.insert(dormrepair);
        }
        return Result.success();
    }
}
