package com.springboot.controller;

import com.springboot.pojo.LayuiUser;
import com.springboot.pojo.ResultBean;
import com.springboot.service.LayuiUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("user")
public class LayuiUserController {
    @Autowired
    private LayuiUserService layuiUserService;
    //查询后台用户数据，分页和完全查询
    @RequestMapping("list")
    public ResultBean list(@RequestParam(defaultValue = "1") int page,
                           @RequestParam(defaultValue = "10") int limit
                        ){
        List<LayuiUser> users = layuiUserService.getPage(page, limit);
        int count = layuiUserService.findAllUsers();
        return new ResultBean(0,"查询成功",count,users);
        }
    //按条件查询
    @RequestMapping("queryByParam")
    public ResultBean queryByParam(@RequestParam(value = "page",required = false) int page,
                                   @RequestParam(value = "limit",required = false) int limit,
                                   @RequestParam(value="city",required = false) String city,
                                   @RequestParam(value="id",required = false) String id,
                                   @RequestParam(value="start",required = false) String start,
                                   @RequestParam(value="end",required = false) String end,
                                   @RequestParam(value="name",required = false) String name
                                   ){
        int uid = 0;
        if(id!=null&&!(id.equals(""))){
             uid = Integer.valueOf(id);
        }
        //查询所有符合条件数据
        List<LayuiUser> users = layuiUserService.queryByParam(city,uid,start,end,name);
        //分页获取符合条件数据
        List<LayuiUser> users2 = layuiUserService.queryByParamPage(page,limit,city,uid,start,end,name);
        //获取总条数
        int count = users.size();

        return new ResultBean(0,"查询成功",count,users2);

    }
    //修改或新增用户
    @RequestMapping("save")
    public ResultBean save(@RequestBody LayuiUser user){
        //获取数据条数
        int count = layuiUserService.findAllUsers();
        //获取所有用户
        List<LayuiUser> users = layuiUserService.findAllUsersList();
        // 判断是新增还是修改

        if(user.getId()==0){//用户不存在
            if (user.getId() <= 0) {
                int index = count - 1;
                if (index < 0) {
                    user.setId(1);
                } else {
                    user.setId(users.get(index).getId() + 1);
                }
            }
            layuiUserService.addUser(user);
        }else{
            layuiUserService.updateUser(user);
        }

        return new ResultBean(200,"保存成功",0,null);
    }
    //删除用户
    @RequestMapping("remove")
    public ResultBean modify(@RequestBody int[] ids){
        layuiUserService.delUsers(ids);
        return new ResultBean(200,"删除成功",0,null);
    }

}
