package com.springboot.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName("teacher")
public class Teacher {
    @TableId
    String teacherid;
    String userid;
    String tname;
    String tphone;
}
