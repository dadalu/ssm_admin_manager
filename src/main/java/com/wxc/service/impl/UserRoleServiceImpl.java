package com.wxc.service.impl;

import com.wxc.entity.UserRole;
import com.wxc.mapper.UserRoleMapper;
import com.wxc.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色对应关系 服务实现类
 * </p>
 *
 * @author wangxiaocheng
 * @since 2021-07-16
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
