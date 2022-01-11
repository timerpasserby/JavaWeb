package com.springboot.service;

import com.springboot.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: cp9
 * @Date: 2020/12/08/15:19
 * @Description:
 */

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;
    public List<Map> findTest(int page, int limit){
        return testDao.findTest(page,limit);
    }
    public int findAllTest(){
        return testDao.findAllTest();
    }
    public List<Map> findNumOfAdress(){
        return testDao.findNumOfAdress();
    }
}
