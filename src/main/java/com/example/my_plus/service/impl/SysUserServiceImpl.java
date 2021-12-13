package com.example.my_plus.service.impl;

import com.example.my_plus.entity.SysUser;
import com.example.my_plus.mapper.SysUserMapper;
import com.example.my_plus.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-12-09
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
