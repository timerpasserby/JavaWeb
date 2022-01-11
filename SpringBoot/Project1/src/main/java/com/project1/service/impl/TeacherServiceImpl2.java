package com.project1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project1.dao.TeacherDao;
import com.project1.pojo.Teacher;
import com.project1.service.ITeacherService;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl2 extends ServiceImpl<TeacherDao, Teacher> implements ITeacherService {
}
