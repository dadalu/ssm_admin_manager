package com.wang.login.service.impl;

import com.wang.login.mapper.LoginMapper;
import com.wang.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public String getPassword(Map map) {
        return mapper.getPassword(map);
    }

    public Map getLoginInfo(Map map) {
        return mapper.getLoginInfo(map);
    }
    public void deleteUser(Map map) {
         mapper.deleteUser(map);
    }
}
