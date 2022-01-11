package com.javaweb;

import com.javaweb.dao.userDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaWebApplicationTests {

    @Autowired
    private userDao userdao;

    @Test
    public void contextLoads() {
        System.out.println(userdao.getById("yyy"));
        System.out.println("123");
    }

}
