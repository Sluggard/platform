package com.sluggard.user.service.impl;

import com.sluggard.user.entity.SysUser;
import com.sluggard.user.mapper.SysUserMapper;
import com.sluggard.user.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
    * 用户表 服务实现类
    * </p>
 *
 * @author lizheng
 * @since 2021-04-30
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
