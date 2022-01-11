package com.springboot.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Course {
    int courseid;
    String teacherid;
    String coursename;
    String courseyear;
    String ishided;
    String coursedeleted;
}
