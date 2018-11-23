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
    String getPassword(Map map);
    Map getLoginInfo(Map map);
    void deleteUser(Map map);
}
