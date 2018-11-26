package com.wang.privilege.service;

import java.util.List;
import java.util.Map;

public interface PrivilegeService {
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 新增权限
     * @Param [map]
     * @return void
     **/
    void insertPrivilege(Map map);
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 删除权限
     * @Param [map]
     * @return void
     **/
    void deletePrivilege(Map map);
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 分配权限
     * @Param [map]
     * @return void
     **/
    void assignPrivilege(Map map);
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 获取权限
     * @Param [map]
     * @return java.util.List
     **/
    List getPrivilege(Map map);
}
