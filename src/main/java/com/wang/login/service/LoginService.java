package com.wang.login.service;

import java.util.Map;

/**
 * @author XiaochengWang
 * @Title: LoginService
 * @ProjectName ssm_admin_manager
 * @Description: TODO
 * @date 2018/11/19 10:36
 */
public interface LoginService {
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 获取密码
     * @Param [map]
     * @return java.lang.String
     **/
    Map getPassword(Map map);
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 获取登陆信息
     * @Param [map]
     * @return java.lang.String
     **/
    Map getLoginInfo(Map map);
}
