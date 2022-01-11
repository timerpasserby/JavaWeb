package com.springboot.controller;


import com.springboot.pojo.ResultBean;
import com.springboot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: cp9
 * @Date: 2020/12/08/15:21
 * @Description:
 */

@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    private TestService testService;
    //查询后台用户数据，分页和完全查询
    @RequestMapping("list")
    public ResultBean list(@RequestParam(defaultValue = "1") int page,
                           @RequestParam(defaultValue = "10") int limit
    ){
        List<Map> tests = testService.findTest(page, limit);
        int count = testService.findAllTest();
        System.out.println(count);
        return new ResultBean(0,"查询成功",count,tests);
    }
   @RequestMapping("dataTobin")
    public Map<String,List<Map>> dataToPic1(){
        Map<String,List<Map>> mp = new HashMap<>();
        mp.put("data_pie",testService.findNumOfAdress());
        return mp;
   }
   //获取数据给折线图，柱形图
   @RequestMapping("dataTozhuAndzhe")
    public Map<String,List> dataToPic2(){
        List<Integer> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<Map> list = testService.findNumOfAdress();
        for(int i=0;i<list.size();++i){
            Map mp ;
            mp = list.get(i);
            list1.add(Integer.valueOf(mp.get("value").toString()));
            list2.add(mp.get("name").toString());
        }
      Map<String,List> map = new HashMap<>();
        map.put("x",list2);
        map.put("y",list1);
        return map;
   }
}
