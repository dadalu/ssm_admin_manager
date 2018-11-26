package com.wang.user.service;

import com.wang.user.bo.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 查看用户所有信息
     * @Param [map]
     * @return java.util.List<com.wang.user.bo.User>
     **/
    List<User> getUser(Map map);
     /*
     *
      * @Author XiaochengWang
      * @Description //TODO 获取单一用户信息
      * @Param [map]
      * @return java.util.Map
      **/
    Map getUserInfo(Map map);
     /*
     *
      * @Author XiaochengWang
      * @Description //TODO 搜索查找用户时，返回用户数
      * @Param [map]
      * @return java.util.Map
      **/
    Map getUserCount(Map map);
     /*
     *
      * @Author XiaochengWang
      * @Description //TODO 新增用户
      * @Param [map]
      * @return void
      **/
    void insertUser(Map map);
     /*
     *
      * @Author XiaochengWang
      * @Description //TODO 更新用户
      * @Param [map]
      * @return void
      **/
    void updateUser(Map map);
     /*
     *
      * @Author XiaochengWang
      * @Description //TODO 删除用户
      * @Param [map]
      * @return void
      **/
    void deleteUser(Map map);
     /*
     *
      * @Author XiaochengWang
      * @Description //TODO 获取我的档案信息
      * @Param [map]
      * @return java.util.List
      **/
    List getUserPrivateInfo(Map map);
     /*
     *
      * @Author XiaochengWang
      * @Description //TODO 删除管理员，同时删除组内用户
      * @Param [map]
      * @return java.util.List
      **/
    List selectUserInGroup(Map map);
     /*
     *
      * @Author XiaochengWang
      * @Description //TODO 
      * @Param [map]
      * @return void
      **/
    void deleteAdmin(Map map);
}
