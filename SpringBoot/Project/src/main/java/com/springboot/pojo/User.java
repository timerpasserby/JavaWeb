package com.springboot.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
    String userid;
    String password;
    int role;
}
