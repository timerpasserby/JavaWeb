package com.springboot.controller;

import com.springboot.pojo.Admin;
import com.springboot.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;
//登录验证
    @RequestMapping("checkLogin")
    public String checkLogin(@RequestParam String username,
                             @RequestParam String password, HttpSession session) {
        Admin admin = new Admin(username, password);

        if (adminService.findAdmin(admin).size() == 0) {
            return "用户名不存在或密码错误!";
        }

        session.setAttribute("admin",admin );
        return "success";
    }
//修改密码
    @RequestMapping("changePwd")
    public Map<String, String> changePwd(String repassword, HttpSession session) throws IOException {
        Admin sessionAdmin = (Admin) session.getAttribute("admin");
        String name = sessionAdmin.getName();
        Admin admin2 = new Admin(name,repassword);
        int result = adminService.changePwd(admin2);
        Map<String, String> data = new HashMap<>();
        if (result > 0) {
            data.put("msg", "0");
        } else {
            data.put("msg", "1");
        }
        return data;
    }
//退出登录
    @RequestMapping("logOut")
    public Map<String,String> logOut(HttpServletRequest request){
       HttpSession session = request.getSession();
       session.invalidate();
        Map<String, String> data = new HashMap<>();
        data.put("msg", "ok");
        return data;
    }
}
