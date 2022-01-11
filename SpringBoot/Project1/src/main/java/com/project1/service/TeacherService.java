package com.project1.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.project1.pojo.Teacher;

import java.util.List;

public interface TeacherService {
    Boolean save(Teacher teacher);
    Boolean update(Teacher teacher);
    Boolean delete(String tid);
    Teacher getById(String tid);
    List<Teacher> getAll();
    IPage<Teacher> getPage(int currentPage,int pageSize);
}
