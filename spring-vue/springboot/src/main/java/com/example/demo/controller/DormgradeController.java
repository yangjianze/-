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
import com.example.demo.entity.Dormitoryinfo;
import com.example.demo.entity.Student;
import com.example.demo.mapper.DormgradeMapper;
import com.example.demo.mapper.DormitoryinfoMapper;
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
@RequestMapping("/dormgrade")
public class DormgradeController {
    @Resource
    DormgradeMapper dormgradeMapper;

    @PostMapping//新增
    public Result<?> save(@RequestBody Dormgrade dormgrade){
        dormgradeMapper.insert(dormgrade);
        return Result.success();
    }

    @PutMapping//修改
    public Result<?> update(@RequestBody Dormgrade dormgrade){
        dormgradeMapper.updateById(dormgrade);
        return Result.success();
    }

    @DeleteMapping("/{id}")//删除
    public Result<?> delete(@PathVariable Long id){
        dormgradeMapper.deleteById(id);
        return Result.success();
    }

    @PostMapping("/deleteBatch")//批量删除
    public Result<?> deleteBatch(@RequestBody List<Integer> ids){
        dormgradeMapper.deleteBatchIds(ids);
        return  Result.success();
    }

    @GetMapping//查询
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search){
        LambdaQueryWrapper<Dormgrade> wrapper = Wrappers.<Dormgrade>lambdaQuery();
        if (StrUtil.isNotBlank(search)){
            wrapper.like(Dormgrade::getDormitoryid,search);
        }
        Page<Dormgrade> userPage = dormgradeMapper.selectPage(new Page<>(pageNum,pageSize),wrapper);
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
        List<Dormgrade> all = dormgradeMapper.selectList(null);
        for (Dormgrade dormgrade : all) {
            Map<String, Object> row1 = new LinkedHashMap<>();
//            row1.put("编号", student.getId());
            row1.put("宿舍编号", dormgrade.getDormitoryid());
            row1.put("宿舍楼", dormgrade.getDormbuilding());
            row1.put("宿舍卫生", dormgrade.getGrade());
            row1.put("开始时间", dormgrade.getCreatetime());
            row1.put("结束时间", dormgrade.getUpdatetime());
            list.add(row1);
        }
        // 2. 写 excel
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(list, true);
        response.setContentType("application/vnd.openxmlformatsofficedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("宿舍卫生", "UTF-8");
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
        List<Dormgrade> saveList = new ArrayList<>();
        for (List<Object> row : lists) {
            Dormgrade dormgrade = new Dormgrade();
//            classs.setId(row.get(0).toString());
            dormgrade.setDormitoryid(new Integer(row.get(0).toString()));
            dormgrade.setDormbuilding(row.get(1).toString());
            dormgrade.setGrade(new Integer(row.get(2).toString()));
            dormgrade.setCreatetime(row.get(3).toString());
            dormgrade.setUpdatetime(row.get(4).toString());
            saveList.add(dormgrade);
        }
        for (Dormgrade dormgrade : saveList) {
            dormgradeMapper.insert(dormgrade);
        }
        return Result.success();
    }
}
