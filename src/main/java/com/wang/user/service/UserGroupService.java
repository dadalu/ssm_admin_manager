package com.wang.user.service;

import com.wang.user.bo.User;

import java.util.List;
import java.util.Map;

public interface UserGroupService {
    /**
     * 获取所有用户信息
     * @return
     */
    List<User> getUser();
    /**
     * 获取当前用户信息
     * @return
     */
    Map getUserInfo(Map map);
}
