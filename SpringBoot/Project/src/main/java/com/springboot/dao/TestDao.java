package com.springboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: cp9
 * @Date: 2020/12/08/15:13
 * @Description:
 */
@Repository
@Mapper
public interface TestDao {
    List<Map> findTest(@Param("page") int page,
                       @Param("limit") int limit);
    int findAllTest();
    List<Map> findNumOfAdress();
}
