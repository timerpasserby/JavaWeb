package com.project1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project1.dao.UserDao;
import com.project1.pojo.User;
import com.project1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {

}
