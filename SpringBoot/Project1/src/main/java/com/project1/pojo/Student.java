package com.project1.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Student {
    String studentid;
    String useid;
    String name;
    String sex;
    String phone;
    String major;
    String grade;
    String isdeleted;
}
