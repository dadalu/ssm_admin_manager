package com.wang.privilege.service.impl;

import com.alibaba.fastjson.JSONArray;
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
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 新增权限
     * @Param [map]
     * @return void
     **/
    public void insertPrivilege(Map map) {
        mapper.insertPrivilege(map);
    }
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 删除权限
     * @Param [map]
     * @return void
     **/
    public void deletePrivilege(Map map) {
        mapper.deletePrivilege(map);
    }
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 获取权限
     * @Param [Map]
     * @return java.util.Map
     **/
    public List getPrivilege(Map map) {
        List returnList = mapper.getPrivilege(map);
        System.out.println(returnList);
        return returnList;
    }
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 分配权限
     * @Param [map]
     * @return void
     **/
    public void assignPrivilege(Map map){
        String str = (String)map.get("params");
        List<Map<String, Integer>> iterator = (List<Map<String, Integer>>) JSONArray.parse(str);
        List privilegeList = new ArrayList();
        Map paramsMap = new HashMap();
        paramsMap.put("roleId",map.get("roleId"));
        for (Map<String,Integer> mapList:iterator) {
            for (Map.Entry entry:mapList.entrySet()
                    ) {
                Map privilegeMap =new HashMap();
                privilegeMap.put(entry.getKey(),entry.getValue());
                privilegeList.add(privilegeMap);
            }
        }
        paramsMap.put("privilegeList",privilegeList);

        List list = (List)map.get("privilegeList");
        String id = (String)map.get("roleId");
        int roleId = Integer.parseInt(id);
        for (int i = 0; i < list.size(); i++) {
            Map m = (Map)list.get(i);
            int privilegeId = Integer.parseInt((String)m.get("privilegeId"));
            Map paramMap = new HashMap();
            paramMap.put("roleId",roleId);
            paramMap.put("privilegeId",privilegeId);
            mapper.assignPrivilege(paramsMap);
        }
    }
}
