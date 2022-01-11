package com.springboot.dao;


import com.springboot.pojo.LayuiUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface LayuiUserDao {
    //更新用户
    void updateUser(LayuiUser layuiUser);
    //批量删除用户
    void delUsers(@Param("id") int id);
    //增加用户
    void addUser(LayuiUser layuiUser);
    //查询所有用户数
    int findAllUsers();
    //查询所有用户集合
    List<LayuiUser> findAllUsersList();
    //分页获取用户
    List<LayuiUser> getPage(@Param("start") int page, @Param("size") int limit);

    //按条件查询
    List<LayuiUser> queryByParam(@Param("city") String city,
                                 @Param("id") int id,
                                 @Param("start") String start,
                                 @Param("end") String end,
                                 @Param("name") String name);
    //按条件查询并分页
    List<LayuiUser> queryByParamPage(@Param("page") int page,
                                 @Param("limit") int limit,
                                 @Param("city") String city,
                                 @Param("id") int id,
                                 @Param("start") String start,
                                 @Param("end") String end,
                                 @Param("name") String name);

}
