package com.wang.privilege.service;

import java.util.List;
import java.util.Map;

public interface PrivilegeService {
    /**
     * 新增角色
     * @param map
     */
    void insertPrivilege(Map map);
    /**
     *删除角色
     * @param map
     */
    void deletePrivilege(Map map);
    void assignPrivilege();
    /**
     *查看角色
     */
    List getPrivilege(Map map);
}
