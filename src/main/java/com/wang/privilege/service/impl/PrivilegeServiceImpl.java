package com.wang.privilege.service.impl;

import com.wang.privilege.mapper.PrivilegeMapper;
import com.wang.privilege.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("PrivilegeService")
public class PrivilegeServiceImpl implements PrivilegeService {
    @Autowired
    private PrivilegeMapper mapper;
    public void insertPrivilege(Map map) {
        mapper.insertPrivilege(map);
    }

    public void deletePrivilege(Map map) {
        mapper.deletePrivilege(map);
    }
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO
     * @Param [Map]
     * @return java.util.Map
     **/
    public List getPrivilege(Map map) {
        List returnList = mapper.getPrivilege(map);
        System.out.println(returnList);
        return returnList;
    }
    public void assignPrivilege(Map map){
        List list = (List)map.get("privilegeList");
        String id = (String)map.get("roleId");
        int roleId = Integer.parseInt(id);
        for (int i = 0; i < list.size(); i++) {
            Map m = (Map)list.get(i);
            int privilegeId = Integer.parseInt((String)m.get("privilegeId"));
            Map paramsMap = new HashMap();
            paramsMap.put("roleId",roleId);
            paramsMap.put("privilegeId",privilegeId);
            mapper.assignPrivilege(paramsMap);
        }
    }
}
