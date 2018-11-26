package com.wang.role.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface RoleService {
    /**
     * 新增角色
     * @param map
     */
    void insertRole(Map map);
    /**
     *删除角色
     * @param map
     */
    void deleteRole(Map map);
    /**
     *查看角色
     */
    List getRole(Map map);
}
