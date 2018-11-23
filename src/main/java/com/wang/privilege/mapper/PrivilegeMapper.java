package com.wang.privilege.mapper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public interface PrivilegeMapper {
    /**
     * 新增权限
     * @param map
     */
    void insertPrivilege(Map map);
    /**
     *删除权限
     * @param map
     */
    void deletePrivilege(Map map);
    /**
     *查看权限
     */
    List getPrivilege(Map map);
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 
     * @Param [list]
     * @return void
     **/
    void assignPrivilege(List<Map> list);
}
