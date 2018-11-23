package com.wang.role.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RoleMapper {
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
    List getRole();

}
