package com.project1;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project1.dao.TeacherDao;
import com.project1.pojo.Teacher;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class Project1ApplicationTests {

    @Autowired
    private TeacherDao teacherDao;
    @Test
    void contextLoads() {
        List<Teacher> teacherList=teacherDao.selectList(null);
        teacherList.forEach(System.out::println);
    }
    @Test
    void testInsert(){
        Teacher teacher=new Teacher();
        teacher.setTeacherid("0005");
        teacher.setUsersid("0001");
        teacher.setTname("王丽");
        teacherDao.insert(teacher);
    }
    @Test
    void testGetPage(){
        IPage page=new Page(1,5);
        teacherDao.selectPage(page,null);//返回的对象是IPage

        System.out.println(page.getPages());
        System.out.println(page.getRecords());
        System.out.println();

    }
    @Test
    void testGetByWrapper(){
        LambdaQueryWrapper<Teacher> qw=new QueryWrapper<Teacher>().lambda();
//        条件查询
//        String name=null;
//        qw.like(name!=null,"tname",name);
////        qw.likeLeft(); 左查询
////        qw.likeRight() 右查询
//        teacherDao.selectList(qw);



//        LambdaQueryWrapper做语法的检查，防止出错
        qw.like(Teacher::getTname,"三");

        teacherDao.selectList(qw);
    }
}
