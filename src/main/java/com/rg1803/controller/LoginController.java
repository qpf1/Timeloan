package com.rg1803.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.rg1803.dao.LoginMapper;
import com.rg1803.pojo.User;
import com.rg1803.service.LoginService;

@Controller
@ResponseBody
public class LoginController {
	
	@Autowired
	private LoginService ls;
	@Autowired
	private LoginMapper lm;
	
	@RequestMapping(value = "/login.action")
	public String login(User u,HttpSession session) {//验证用户的账号密码
		Boolean bo = ls.login(u);
		HashMap<Object,Object> map = new HashMap<>();
		if(bo) {
			User user = lm.login(u);
			map.put("bo", bo);
			map.put("user", user);
			session.setAttribute("user", user);
			return JSON.toJSONString(map);
		}else {
			map.put("bo", bo);
			return JSON.toJSONString(map);
		}
	}
	
	@RequestMapping(value = "/agree.action")
	public String agree(User u) {
		Integer i = ls.agree(u);
		if(i>0) {
			return JSON.toJSONString(true);
		}else {
			return JSON.toJSONString(false);
		}
	}
	
	@RequestMapping(value = "/zhuxiao.action")
	public String zhuxiao(HttpSession session) {
		session.setAttribute("user", null);
		return JSON.toJSONString(true);
	}
	
	@RequestMapping(value = "/checklogin.action")
	public String checklogin(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user!=null) {
			return JSON.toJSONString(true);
		}else {
			return JSON.toJSONString(false);
		}
	}
	
	
	@RequestMapping(value = "/zhuce.action")
	public String zhuce(HttpSession session) {
		User user = (User) session.getAttribute("user");
		Integer isemp = user.getIsemp();
		if(isemp!=null) {
			return JSON.toJSONString(true);
		}else {
			return JSON.toJSONString(false);
		}
	}
}
