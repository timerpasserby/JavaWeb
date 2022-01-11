package com.springboot.service;


import com.springboot.dao.LayuiUserDao;
import com.springboot.pojo.LayuiUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class LayuiUserServiceImpl implements LayuiUserService {
    @Autowired
    private LayuiUserDao layuiUserDao;

    //更新用户
    public void updateUser(LayuiUser layuiUser) {
        layuiUserDao.updateUser(layuiUser);
    }

    //批量删除用户
    public void delUsers(int[] ids){
        for(int i = 0;i<ids.length;++i) {
            layuiUserDao.delUsers(ids[i]);
        }
    }
    //增加用户
   public void addUser(LayuiUser layuiUser){
        layuiUserDao.addUser(layuiUser);
    }

    //查询所有用户数
   public int findAllUsers(){
        return layuiUserDao.findAllUsers();
    }
    //查询所有用户集合
    public List<LayuiUser> findAllUsersList(){
        return layuiUserDao.findAllUsersList();
    }
    //分页获取用户
   public List<LayuiUser> getPage(int page,int limit) {
       return layuiUserDao.getPage(page, limit);
   }
   //按条件查询
    public List<LayuiUser> queryByParam(String city,int id,String start,String end,String name){
        return layuiUserDao.queryByParam(city,id,start,end,name);
    }
    //按条件查询分页
    public List<LayuiUser> queryByParamPage(int page,
                                            int limit,
                                            String city,
                                            int id,
                                            String start,
                                            String end,
                                            String name){
        return layuiUserDao.queryByParamPage(page,limit,city,id,start,end,name);
    }
}
