package com.project1.controller;

import com.project1.controller.utils.R;
import com.project1.pojo.User;
import com.project1.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("api")
public class LoginController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/login")
    public User login() {
        return null;
    }

    @CrossOrigin
    @PostMapping(value = "/login")
    public R login(@RequestBody User user,HttpSession session) {
        // 对html进行转义，防止XSS攻击
        System.out.println(user);
        String username = user.getUsersid();
        username = HtmlUtils.htmlEscape(username);
        String password = user.getPassword();
        if (username.equals("admin") && password.equals("123456")) {
            User adminUser=new User();
            adminUser.setUsersid("admin");
            adminUser.setPassword("123456");
            session.setAttribute("user",adminUser);
            return new R(true, 0);
        } else {
            User loginUser =userService.getById(username);
            if(loginUser!=null && password.equals(loginUser.getPassword())){
                session.setAttribute("user",loginUser);
                return new R(true,loginUser.getRole());
            }
            else {
                return new R(false);
            }
        }
    }
}
