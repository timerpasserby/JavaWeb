package com.project1.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project1.pojo.Teacher;
import com.project1.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private ITeacherService iTeacherService;

    @GetMapping
    public List<Teacher> getAll() {
        return iTeacherService.list();
    }

    @PostMapping
    public Boolean save(@RequestBody Teacher teacher){
        return iTeacherService.save(teacher);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Teacher> testGetPage(@PathVariable int currentPage,@PathVariable int pageSize){
        IPage page=new Page(currentPage,pageSize);
        return iTeacherService.page(page);

    }
}
