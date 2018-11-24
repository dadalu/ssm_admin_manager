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
        List list = service.getPrivilege(map);
        returnMap.put("message","success");
        returnMap.put("code",0);
        returnMap.put("data",list);
        System.out.println(returnMap);
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
        service.deletePrivilege(params);
        return null;
    }
    @RequestMapping(value = "/assignPrivilege.do",method = RequestMethod.POST)
    public Map assignPrivilege(@RequestParam Map map) {
        String str = (String)map.get("params");
        List<Map<String, String>> iterator = (List<Map<String, String>>)JSONArray.parse(str);
        for (Map<String,String> mapList:iterator
             ) {
            for (Map.Entry entry:mapList.entrySet()
                 ) {
                System.out.println(entry.getKey()+" "+entry.getValue());
            }
        }

        return map;
    }
}