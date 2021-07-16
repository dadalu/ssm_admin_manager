package com.wxc.service.impl;

import com.wxc.entity.Role;
import com.wxc.mapper.RoleMapper;
import com.wxc.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author wangxiaocheng
 * @since 2021-07-16
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
