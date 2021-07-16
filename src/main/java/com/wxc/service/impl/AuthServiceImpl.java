package com.wxc.service.impl;

import com.wxc.entity.Auth;
import com.wxc.mapper.AuthMapper;
import com.wxc.service.AuthService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限 服务实现类
 * </p>
 *
 * @author wangxiaocheng
 * @since 2021-07-16
 */
@Service
public class AuthServiceImpl extends ServiceImpl<AuthMapper, Auth> implements AuthService {

}
