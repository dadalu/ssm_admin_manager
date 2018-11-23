package com.wang.role.service.impl;

import com.wang.role.mapper.RoleMapper;
import com.wang.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("RoleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleRapper;
    /**
     * 新增角色
     * @param map
     */
    public void insertRole(Map map){
        roleRapper.insertRole(map);
    }
    /**
     *删除角色
     * @param map
     */
    public void deleteRole(Map map){
        roleRapper.deleteRole(map);
    }
    /**
     *查看角色
     */
    public List getRole(){
        List list = roleRapper.getRole();
        return list;
    }

}
