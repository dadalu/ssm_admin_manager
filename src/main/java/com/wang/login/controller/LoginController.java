package com.wang.login.controller;

import com.wang.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginService loginService;
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
		String message = "success";

		// 调用业务层执行查询操作
		Map returnMap = null;
        try {
			returnMap = loginService.getPassword(params);
        } catch (Exception e) {
			message = "用户名或密码错误";
            e.printStackTrace();
        }
        returnMap.put("code",code);
		returnMap.put("message",message);
		return returnMap;

	}
}
