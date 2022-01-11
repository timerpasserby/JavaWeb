package com.project1.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project1.pojo.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TeacherServiceTest {

    @Autowired
    private ITeacherService teacherService;

    @Test
    void testGetById(){
        System.out.println(teacherService.getById("0003"));
    }

    @Test
    void testSave(){
        Teacher teacher=new Teacher();
        teacher.setTeacherid("0008");
        teacher.setUsersid("0003");
        teacher.setTname("张麻子");
        teacherService.save(teacher);
    }
    @Test
    void testUpdate(){
        Teacher teacher=new Teacher();
        teacher.setTeacherid("0008");
        teacher.setUsersid("0003");
        teacher.setTname("没码子");
        teacherService.updateById(teacher);
    }

    @Test
    void testDelete(){
        teacherService.removeById("0008");
    }

    @Test
    void testGetAll(){
        System.out.println(teacherService.list());
    }

    @Test
    void testGetByPage(){
        IPage<Teacher> ipage=new Page<Teacher>(1,3);
        teacherService.page(ipage);
        System.out.println(ipage.getRecords());
        System.out.println(ipage);
        System.out.println(ipage.getSize());
    }
}
