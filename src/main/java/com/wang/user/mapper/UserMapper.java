package com.wang.user.mapper;

import com.wang.user.bo.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
    /**
     * 查询所有用户信息
     * @return
     */
    List<User> getUser(Map map);
    /**
     * 查询当前用户信息
     * @return
     */
    Map getUserInfo(Map map);
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 添加用户
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
     * @Description //TODO 获取用户信息
     * @Param [map]
     * @return java.util.List
     **/
    List getUserPrivateInfo(Map map);
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 获取用户数
     * @Param [map]
     * @return java.util.Map
     **/
    Map getUserCount(Map map);
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 
     * @Param [map]
     * @return java.util.List
     **/
    List selectUserInGroup(Map map);
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 删除管理员用户
     * @Param [list]
     * @return void
     **/
    void deleteAdmin(List list);

}
