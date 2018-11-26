package com.wang.login.controller;

import com.wang.login.service.LoginService;
import com.wang.user.bo.User;
import com.wang.user.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private User user;
	/*
	*
	 * @Author XiaochengWang
	 * @Description //TODO 登录操作，并获取用户信息
	 * @Param [params]
	 * @return java.util.Map
	 **/
	@RequestMapping(value = "/login.do")
	public Map hello(@RequestParam Map params) {
		int code = 2;
		String message = "用户名或密码错误";
		// 调用业务层执行查询操作
		Map returnMap = new HashMap();
        try {
		    String password = loginService.getPassword(params);
            if(password!=null&&password.equals(params.get("password"))){
                /*returnMap.put("loginInfo",loginService.getLoginInfo(params));*/
                returnMap.putAll(loginService.getLoginInfo(params));
				message = "success";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        returnMap.put("code",code);
		returnMap.put("message",message);
		return returnMap;

	}
	/*@RequestMapping(value = "/getLoginInfo.do")
	@ResponseBody
	public Map getLoginInfo() {
		int code = 0;
		String message = "success";
		Map map = new HashMap();
		map.put("name","董事长");
		map.put("password","tt6439");
		// 调用业务层执行查询操作
		Map returnMap = new HashMap();
		returnMap.put("code",code);
		returnMap.put("message",message);
		returnMap.put("user",user);
		return returnMap;
	}*/


}
