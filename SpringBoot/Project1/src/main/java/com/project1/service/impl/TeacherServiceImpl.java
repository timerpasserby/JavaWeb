package com.project1.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project1.dao.TeacherDao;
import com.project1.pojo.Teacher;
import com.project1.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public Boolean save(Teacher teacher) {
        return teacherDao.insert(teacher) > 0;
    }

    @Override
    public Boolean update(Teacher teacher) {
        return teacherDao.updateById(teacher) > 0;
    }

    @Override
    public Boolean delete(String tid) {
        return teacherDao.deleteById(tid) > 0;

    }

    @Override
    public Teacher getById(String tid) {

        return teacherDao.selectById(tid);
    }

    @Override
    public List<Teacher> getAll() {
        return teacherDao.selectList(null);
    }

    @Override
    public IPage<Teacher> getPage(int currentPage, int pageSize) {
        IPage ipage=new Page(currentPage,pageSize);
        teacherDao.selectPage(ipage,null);
        return ipage;
    }
}
