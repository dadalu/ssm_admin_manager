package com.wang.login.service.impl;

import com.wang.login.mapper.LoginMapper;
import com.wang.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XiaochengWang
 * @Title: LoginServiceImpl
 * @ProjectName ssm_admin_manager
 * @Description: TODO
 * @date 2018/11/19 10:37
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper mapper;
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 获取密码
     * @Param [map]
     * @return java.lang.String
     **/
    public Map getPassword(Map map) {
        Map userMap = null;
        String password = mapper.getPassword(map);
        if(password!=null&&password.equals(map.get("password"))){
            //密码匹配，获取用户信息
            userMap = getLoginInfo(map);
        }
        return userMap;
    }
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 查询登陆信息
     * @Param [map]
     * @return java.util.Map
     **/
    public Map getLoginInfo(Map map) {
        return mapper.getLoginInfo(map);
    }
}
