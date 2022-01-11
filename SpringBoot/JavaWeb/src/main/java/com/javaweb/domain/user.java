package com.javaweb.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class user {
    private String username;
    private String password;
}
