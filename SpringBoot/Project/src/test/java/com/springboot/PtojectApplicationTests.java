package com.springboot;

import com.springboot.dao.TeacherDao;
import com.springboot.pojo.Teacher;
import org.apache.ibatis.jdbc.Null;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("com.springboot.dao")
class PtojectApplicationTests {

    @Autowired
    private TeacherDao teacherDao;
    @Test
    public void testSelect() {
        List<Teacher> teacherList=teacherDao.selectList(null);
        teacherList.forEach(System.out::println);
    }

}
