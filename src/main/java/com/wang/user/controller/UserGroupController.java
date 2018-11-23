package com.wang.user.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XiaochengWang
 * @Title: UserGroupController
 * @ProjectName ssm_admin_manager
 * @Description: TODO
 * @date 2018/11/16 11:17
 */
@Controller
@RequestMapping("/userGroup")
public class UserGroupController {
    @RequestMapping("inertUserGroup")
    public Map insertUserGroup(@RequestParam Map params){
        int code = 0;
        String message = "";
        Map returnMap = new HashMap();
        returnMap.put("code",code);
        returnMap.put("message",message);
        return returnMap;
    }
}
