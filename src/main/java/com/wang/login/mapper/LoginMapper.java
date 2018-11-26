package com.wang.login.mapper;

import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author XiaochengWang
 * @Title: LoginMapper
 * @ProjectName ssm_admin_manager
 * @Description: TODO
 * @date 2018/11/19 10:39
 */
@Repository
public interface LoginMapper {
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 获取密码
     * @Param [map]
     * @return java.lang.String
     **/
    String getPassword(Map map);
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 获取登陆信息
     * @Param [map]
     * @return java.util.Map
     **/
    Map getLoginInfo(Map map);
}
