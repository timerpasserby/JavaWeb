package com.javaweb.dao;

import com.javaweb.domain.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface userDao {
    @Select("select * from user where username=#{username}")
    public user getById(String username);
}
