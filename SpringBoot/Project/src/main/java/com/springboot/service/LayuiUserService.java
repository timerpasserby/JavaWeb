package com.springboot.service;



import com.springboot.pojo.LayuiUser;

import java.util.List;

public interface LayuiUserService {
    //更新用户
    void updateUser(LayuiUser layuiUser);
    //批量删除用户
    void delUsers(int[] ids);
    //增加用户
    void addUser(LayuiUser layuiUser);
    //查询所有用户数
    int findAllUsers();
    //查询所有用户数集合
    List<LayuiUser> findAllUsersList();
    //分页获取用户
    List<LayuiUser> getPage(int page,int limit);
    //按条件查询
    List<LayuiUser> queryByParam(String city,
                                 int id,String start,
                                 String end,
                                 String name);
    //按条件查询分页
    List<LayuiUser> queryByParamPage(int page,
                                     int limit,
                                     String city,
                                     int id,
                                     String start,
                                     String end,
                                     String name);

}
