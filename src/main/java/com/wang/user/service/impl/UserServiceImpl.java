package com.wang.user.service.impl;

import com.wang.user.bo.User;
import com.wang.user.mapper.UserMapper;
import com.wang.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {
    //注入mapper对象，操作mybatis查询
    @Autowired
    private UserMapper userMapper;

    /**
     * 获取所有用户信息
     * @return
     */
    public List<User> getUser(Map map) {
        int page = Integer.parseInt((String)map.get("page"));
        int limit = Integer.parseInt((String)map.get("limit"));
        int num = (page-1)*limit;
        map.put("page",page);
        map.put("limit",limit);
        map.put("num",num);
        List<User> userList = userMapper.getUser(map);
        return userList;
    }

    public Map getUserInfo(Map map) {
        Map userMap = userMapper.getUserInfo(map);
        return userMap;
    }

     public Map getUserCount(Map map){
        return userMapper.getUserCount(map);
    }
    public void insertUser(Map map){
        userMapper.insertUser(map);
    }
    public void updateUser(Map map){
        userMapper.updateUser(map);
    }
    public void deleteUser(Map map){
        userMapper.deleteUser(map);
    }
    public List getUserPrivateInfo(Map map){
        return userMapper.getUserPrivateInfo(map);
    }

    public List selectUserInGroup(Map map) {
        List list =  userMapper.selectUserInGroup(map);
        return list;
    }
/*
*
 * @Author XiaochengWang
 * @Description //TODO 删除管理员，同时删除组内用户
 * @Param [map]
 * @return void
 **/
    public void deleteAdmin(Map map) {
        List list = selectUserInGroup(map);
        userMapper.deleteAdmin(list);
    }
}
