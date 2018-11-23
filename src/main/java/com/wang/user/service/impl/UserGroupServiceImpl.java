package com.wang.user.service.impl;

import com.wang.user.bo.User;
import com.wang.user.mapper.UserGroupMapper;
import com.wang.user.mapper.UserMapper;
import com.wang.user.service.UserGroupService;
import com.wang.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("userGroupService")
public class UserGroupServiceImpl implements UserGroupService {
    //注入mapper对象，操作mybatis查询
    @Autowired
    private UserGroupMapper userGroupMapper;

    /**
     * 获取所有用户信息
     * @return
     */
    public List<User> getUser() {
        List<User> userList = userGroupMapper.getUser();
        return userList;
    }

    public Map getUserInfo(Map map) {
        Map userMap = userGroupMapper.getUserInfo(map);
        return userMap;
    }

    public void insertUser(Map map) {

    }

    public void deleteUser(Map map) {

    }
}
