package com.wang.privilege.controller;

import com.wang.privilege.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @RequestMapping("/assignPrivilege.do")
    public Map assignPrivilege(@RequestParam Map map){
        service.assignPrivilege();
        return null;
    }

}
