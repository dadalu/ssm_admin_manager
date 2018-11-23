package com.wang.user.controller;

import com.wang.user.bo.User;
import com.wang.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 查看用户所有信息
     * @Param []
     * @return java.util.Map
     **/
    @RequestMapping(value = "/getUser.do")
    public Map getUser(@RequestParam Map map) {
        int code = 0;
        String message = "查询成功";
        Map returnMap = new HashMap();
        // 调用业务层执行查询操作
        List<User> userList = null;
        long count= 0;
        if(map.get("userName")!=null){
            try {
                userList = userService.getUser(map);
                count = userList.size();
            } catch (Exception e) {
                message = "查询失败";
                e.printStackTrace();
            }
        }else{
            try {
                Map countMap = userService.getUserCount(map);
                count = (Long)countMap.get("count");
                userList = userService.getUser(map);
            } catch (Exception e) {
                message = "查询失败";
                e.printStackTrace();
            }
        }
        returnMap.put("code",code);
        returnMap.put("count",count);
        returnMap.put("message",message);
        returnMap.put("data",userList);
        return returnMap;
    }
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 查看用户个人信息,已弃用
     * @Param [params]
     * @return java.util.Map
     **/
    @RequestMapping(value = "/getUserInfo.do")
    public Map getUserInfo(@RequestParam Map params) {
        int code = 0;
        String message = "查询成功";
        Map returnMap = new HashMap();
        Map userMap = null;
        try {
            userMap = userService.getUserInfo(params);
        } catch (Exception e) {
            code=1;
            message = "查询失败";
            e.printStackTrace();
        }
        returnMap.put("code",code);
        returnMap.put("message",message);
        returnMap.put("data",userMap);
        return returnMap;
    }
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 保存用户
     * @Param [params]
     * @return java.util.Map
     **/
    @RequestMapping(value = "/insertUser.do")
    public Map insertUser(@RequestParam Map params) {
        int code = 0;
        String message = "保存成功";
        Map returnMap = new HashMap();
        try {
            userService.insertUser(params);
        } catch (Exception e) {
            code = 1;
            message = "保存失败";
            e.printStackTrace();
        }
        returnMap.put("code",code);
        returnMap.put("message",message);
        return returnMap;
    }
    @RequestMapping(value = "/updateUser.do")
    public Map updateUser(@RequestParam Map params) {
        int code = 0;
        String message = "保存成功";
        Map returnMap = new HashMap();
        try {
            userService.updateUser(params);
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
     * @Description //TODO 删除用户
     * @Param [params]
     * @return java.util.Map
     **/
    @RequestMapping(value = "/deleteUser.do")
    public Map deleteUser(@RequestParam Map params) {
        int code = 0;
        String message = "删除成功";
        Map returnMap = new HashMap();
        String user_Id = (String) params.get("userId");
        int userId = Integer.parseInt(user_Id);
        params.remove("userId");
        params.put("userId",userId);
        try {
            if(userId==100001||userId==100002||userId==100004||userId==100003){
                userService.deleteAdmin(params);
            }else{
                userService.deleteUser(params);
            }

        } catch (Exception e) {
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
     * @Description //TODO 查看用户个人信息
     * @Param [map]
     * @return java.util.Map
     **/
    @RequestMapping("/getUserPrivateInfo.do")
    public Map getUserPrivateInfo(@RequestParam Map map){
        Map returnMap = new HashMap();
        int code = 0;
        String message = "查询成功";
        try {
            List list = userService.getUserPrivateInfo(map);
            returnMap.put("data",list);
        } catch (Exception e) {
            message = "查询失败";
            e.printStackTrace();
        }
        returnMap.put("message",message);
        returnMap.put("code",code);
        System.out.println(returnMap);
        return returnMap;
    }

}
