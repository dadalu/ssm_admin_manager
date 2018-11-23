package com.wang.user.service;

import com.wang.user.bo.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 获取所有用户信息
     * @return
     */
    List<User> getUser(Map map);
    /**
     * 获取当前用户信息
     * @return
     */
    Map getUserInfo(Map map);
    Map getUserCount(Map map);
    void insertUser(Map map);
    void updateUser(Map map);
    void deleteUser(Map map);
    List getUserPrivateInfo(Map map);

    List selectUserInGroup(Map map);
    void deleteAdmin(Map map);
}
