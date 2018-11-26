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
     * @Description //TODO 获取权限
     * @Param [map]
     * @return java.util.Map
     **/
    @RequestMapping("/getPrivilege.do")
    public Map getPrivilege(@RequestParam Map map){
        int code = 0;
        String message = "查询成功";
        Map returnMap = new HashMap();
        try {
            List list = service.getPrivilege(map);

            returnMap.put("data",list);
            System.out.println(returnMap);
        } catch (Exception e) {
            code = 1;
            message = "查询失败";
            e.printStackTrace();
        }
        returnMap.put("message",message);
        returnMap.put("code",code);
        return returnMap;
    }
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 添加权限
     * @Param [map]
     * @return java.util.Map
     **/
    @RequestMapping("/insertPrivilege.do")
    public Map insertPrivilege(@RequestParam Map map){
        int code = 0;
        String message = "保存成功";
        Map returnMap = new HashMap();
        try {
            service.insertPrivilege(map);
        } catch (Exception e) {
            code = 1;
            message = "保存失败";
            e.printStackTrace();
        }
        returnMap.put("code",code);
        returnMap.put("message",message);
        return returnMap;
    }
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 删除权限
     * @Param []
     * @return java.util.Map
     **/
    @RequestMapping("/deletePrivilege.do")
    public Map deletePrivilege(@RequestParam Map map){
        int code = 0;
        String message = "删除成功";
        Map returnMap = new HashMap();
        try {
            service.deletePrivilege(map);
        } catch (Exception e) {
            code = 1;
            message = "删除失败";
            e.printStackTrace();
        }
        returnMap.put("code",code);
        returnMap.put("message",message);
        return returnMap;
    }
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 分配权限
     * @Param [map]
     * @return java.util.Map
     **/
    @RequestMapping(value = "/assignPrivilege.do",method = RequestMethod.POST)
    public Map assignPrivilege(@RequestParam Map map) {
        int code = 0;
        String message = "删除成功";
        Map returnMap = new HashMap();
        try {
            service.assignPrivilege(map);
        } catch (Exception e) {
            code = 1;
            message = "删除失败";
            e.printStackTrace();
        }

        returnMap.put("code",code);
        returnMap.put("message",message);
        return returnMap;
    }
}