package com.project1.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName(value = "teacher")
public class Teacher {
    @TableId
    String teacherid;
    String usersid;
    String tname;
    String tphone;
}
