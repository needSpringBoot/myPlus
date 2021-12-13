package com.example.my_plus.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Parent implements Serializable {
    private Integer isDel;
    private Long createUser;
    private Long updateUser;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
