package com.wxc.common.shiro;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wxc.entity.User;
import com.wxc.entity.UserRole;
import com.wxc.service.UserRoleService;
import com.wxc.service.UserService;
import com.wxc.service.impl.UserRoleServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wangxiaocheng
 * @title: CustomRealm
 * @projectName base-provider
 * @description: TODO
 * @date 2021/7/16 16:03
 */
public class CustomRealm extends AuthorizingRealm {
    @Autowired
    protected UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        QueryWrapper<UserRole> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", user.getId());
        List<UserRole> userRolelist = userRoleService.list();
        Set<String> roles = new HashSet<>();
        for (UserRole userRole : userRolelist) {
            roles.add(String.valueOf(userRole.getRoleId()));
        }
        return new SimpleAuthorizationInfo(roles);
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("name", authenticationToken.getPrincipal());
        User user = userService.getOne(wrapper);
        if (user == null) {
            throw new AccountException("用户名或密码不正确！");
        }
        return new SimpleAuthenticationInfo(user,authenticationToken.getCredentials(),getName());
    }
}
