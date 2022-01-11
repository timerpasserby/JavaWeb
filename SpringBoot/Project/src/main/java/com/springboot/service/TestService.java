package com.springboot.service;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: cp9
 * @Date: 2020/12/08/15:17
 * @Description:
 */


public interface TestService {
    List<Map> findTest(int page, int limit);
    int findAllTest();
    List<Map> findNumOfAdress();
}
