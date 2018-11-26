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

    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 获取所有用户
     * @Param [map]
     * @return java.util.List<com.wang.user.bo.User>
     **/
    public List<User> getUser(Map map) {
        int page = Integer.parseInt((String)map.get("page"));
        //用于分页
        int limit = Integer.parseInt((String)map.get("limit"));
        int num = (page-1)*limit;
        map.put("page",page);
        map.put("limit",limit);
        map.put("num",num);
        List<User> userList = userMapper.getUser(map);
        return userList;
    }
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 获取单一用户信息
     * @Param [map]
     * @return java.util.Map
     **/
    public Map getUserInfo(Map map) {
        Map userMap = userMapper.getUserInfo(map);
        return userMap;
    }
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 搜索查找用户时，返回用户数
     * @Param [map]
     * @return java.util.Map
     **/
     public Map getUserCount(Map map){
        return userMapper.getUserCount(map);
    }
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 新增用户
     * @Param [map]
     * @return void
     **/
    public void insertUser(Map map){
        userMapper.insertUser(map);
    }
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 更新用户
     * @Param [params]
     * @return void
     **/
    public void updateUser(Map params){
        String str = (String)params.get("userId");
        params.remove("userId");
        int userId = Integer.parseInt(str);
        params.put("userId",userId);
        userMapper.updateUser(params);
    }
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 删除用户
     * @Param [map]
     * @return void
     **/
    public void deleteUser(Map map){
        userMapper.deleteUser(map);
    }
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 获取我的档案信息
     * @Param [map]
     * @return java.util.List
     **/
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
