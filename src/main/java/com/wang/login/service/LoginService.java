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
     * @Description //TODO
     * @Param [map]
     * @return java.lang.String
     **/
    String getPassword(Map map);
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO
     * @Param [map]
     * @return java.lang.String
     **/
    Map getLoginInfo(Map map);
    void deleteUser(Map map);
}
