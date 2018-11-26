package com.wang.privilege.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.sun.tools.javac.code.Attribute;
import com.wang.privilege.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("privilege")
public class PrivilegeController {

    @Autowired
    private PrivilegeService service;
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 
     * @Param [map]
     * @return java.util.Map
     **/
    @RequestMapping("/getPrivilege.do")
    public Map getPrivilege(@RequestParam Map map){
        Map returnMap = new HashMap();
        try {
            List list = service.getPrivilege(map);
            returnMap.put("message","success");
            returnMap.put("code",0);
            returnMap.put("data",list);
            System.out.println(returnMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnMap;
    }
    @RequestMapping("/insertPrivilege.do")
    public Map insertPrivilege(@RequestParam Map map){
        int code = 0;
        String message = "success";
        Map returnMap = new HashMap();
        try {
            service.insertPrivilege(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        returnMap.put("code",code);
        returnMap.put("message",message);
        return returnMap;
    }
    @RequestMapping("/deletePrivilege.do")
    public Map deletePrivilege(){
        Map params = new HashMap();
        params.put("privilegeName","财务");
        try {
            service.deletePrivilege(params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping(value = "/assignPrivilege.do",method = RequestMethod.POST)
    public Map assignPrivilege(@RequestParam Map map) {
        String str = (String)map.get("params");
        List<Map<String, Integer>> iterator = (List<Map<String, Integer>>)JSONArray.parse(str);
        List privilegeList = new ArrayList();
        Map paramsMap = new HashMap();
        paramsMap.put("roleId",map.get("roleId"));
        for (Map<String,Integer> mapList:iterator
             ) {
            for (Map.Entry entry:mapList.entrySet()
                 ) {
                Map privilegeMap =new HashMap();
                privilegeMap.put(entry.getKey(),entry.getValue());
                privilegeList.add(privilegeMap);
            }
        }
        paramsMap.put("privilegeList",privilegeList);
        try {
            service.assignPrivilege(paramsMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }
}