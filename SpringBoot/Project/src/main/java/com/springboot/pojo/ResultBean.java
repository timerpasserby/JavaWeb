package com.springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class ResultBean implements Serializable {
    //此处code,count,data严格按照layui设计
    //结果状态码
    private int code;
    //请求结果(是否成功)
    private String msg;
    //结果数
    private int count;
    //结果集
    private Object data;
}
