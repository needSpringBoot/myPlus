package com.example.my_plus.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.my_plus.entity.SysUser;
import com.example.my_plus.service.ISysUserService;
import com.example.my_plus.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-12-09
 */
@RestController
@RequestMapping("/sys-user")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    @GetMapping("/list")
    public R list(Page page, SysUser sysUser){
        return R.ok(sysUserService.page(page, Wrappers.lambdaQuery(sysUser)));
    }

}
