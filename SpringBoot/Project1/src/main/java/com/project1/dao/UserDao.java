package com.project1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project1.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {
}
