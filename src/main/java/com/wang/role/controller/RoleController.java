package com.wang.role.controller;
import com.wang.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService service;
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 查看角色
     * @Param []
     * @return java.util.Map
     **/
    @RequestMapping("/getRole.do")
    public Map getRole(@RequestParam Map map){
        int code =0;
        String message = "角色查询成功";
        Map returnMap = new HashMap();
        List list = null;
        try {
            list = service.getRole(map);
        } catch (Exception e) {
            code=1;
            message = "角色查询失败";
            e.printStackTrace();
        }
        System.out.println(returnMap);
        returnMap.put("message",message);
        returnMap.put("code",code);
        returnMap.put("data",list);
        System.out.println(returnMap);
        return returnMap;
    }
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 添加角色
     * @Param [map]
     * @return java.util.Map
     **/
    @RequestMapping("/insertRole.do")
    public Map insertRole(@RequestParam Map map){
        int code =0;
        String message = "角色添加成功";
        Map returnMap = new HashMap();
        try {
            service.insertRole(map);
        } catch (Exception e) {
            code=1;
            message = "角色添加失败";
            e.printStackTrace();
        }
        returnMap.put("message",message);
        returnMap.put("code",code);
        return returnMap;
    }
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 删除角色
     * @Param []
     * @return java.util.Map
     **/
    @RequestMapping("/deleteRole.do")
    public Map deleteRole(@RequestParam Map map){
        int code =0;
        String message = "角色删除成功";
        Map returnMap = new HashMap();
        try {
            service.deleteRole(map);
        } catch (Exception e) {
            code=1;
            message = "角色删除失败";
            e.printStackTrace();
        }
        returnMap.put("message",message);
        returnMap.put("code",code);
        return returnMap;
    }
}
