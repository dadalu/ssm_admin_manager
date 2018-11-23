/*
package com.wang.user.controller;

import com.wang.user.bo.User;
import com.wang.user.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private DemoService demoService;
	@Autowired
	private User user;
	@RequestMapping(value = "/login.do")
	@ResponseBody
	public Map hello(@RequestParam Map params) {
		System.out.println(params);
		int code = 2;
		String message = "success";
		// 调用业务层执行查询操作
		Map returnMap = new HashMap();

		returnMap.put("code",code);
		returnMap.put("message",message);
		return returnMap;

	}
	@RequestMapping(value = "/getUser.do")
	@ResponseBody
	public Map getUser() {
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
	}


}
*/
