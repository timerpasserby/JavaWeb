package com.springboot.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SC {
    int scid;
    int courseid;
    String studentid;
    String scdeleted;
}
