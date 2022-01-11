package com.springboot.controller;

import com.springboot.dao.TeacherDao;
import com.springboot.pojo.ResultBean;
import com.springboot.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    private TeacherDao teacher;

    @RequestMapping("list")
    public void list(@RequestParam (defaultValue = "1") int page,@RequestParam(defaultValue = "10") int limit){

    }
}
