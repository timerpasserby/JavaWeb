package com.project1.controller.utils;

import lombok.Data;

@Data
public class R {
    private Boolean flag;
    private int role;
    private Object data;

    public R(){}

    public R(Boolean flag){
        this.flag=flag;
    }

    public R (Boolean flag,int role){
        this.flag=flag;
        this.role=role;
    }
}
