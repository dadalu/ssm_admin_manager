package com.wang.user.service.impl;

import com.wang.user.mapper.DemoMapper;
import com.wang.user.bo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wang.user.service.DemoService;

import java.util.*;

@Service("demoService")
public class DemoServiceImpl implements DemoService{
	/*@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	// mybatis sql模板的命名空间
	private static final String NAMESPACE = "com.wang.user.mapper.DemoMapper";

	public void test() {
			System.out.println("返回查询结果集 -> " + sqlSessionTemplate.selectList(NAMESPACE + ".getTest")); // 查询结果集
	}*/
	@Autowired
	private DemoMapper DemoMapper;
	@Autowired
	private User user;
	public List<User> getUser(Map map){
		List<User> userlist = new ArrayList<User>();
		List<Map> list = DemoMapper.getUser(map);
		List menuList = new ArrayList();
		String name = (String)list.get(0).get("user_name");
		for (Map params:list) {
			menuList.add(params.get("menu_name"));
		}
		user.setId(100001);
		user.setName(name);
		user.setDepartment("董事会");
		user.setJoinDate(new Date(2012-01-01));
		user.setSalary(5000);
		user.setScore("90");
		user.setSex("男");
		user.setSign("工作质量第一位");
		user.setCity("郑州");
		user.setClassify("程序员");
		user.setUniversity("中国大学");
		System.out.println(user);
		userlist.add(user);
		userlist.add(user);
		userlist.add(user);
		userlist.add(user);
		userlist.add(user);
		userlist.add(user);
		userlist.add(user);
		userlist.add(user);
		userlist.add(user);
		userlist.add(user);
		userlist.add(user);
		userlist.add(user);
		userlist.add(user);
		userlist.add(user);
		userlist.add(user);
		userlist.add(user);
		userlist.add(user);
		userlist.add(user);
		userlist.add(user);
		return userlist;
	}

}
