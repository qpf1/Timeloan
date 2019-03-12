package com.rg1803.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.rg1803.pojo.URole;
import com.rg1803.pojo.User;
import com.rg1803.service.VerifyMessageService;

@Controller
@ResponseBody
public class VerifyMessageController {

	@Autowired
	private VerifyMessageService vms;
	
	
	@RequestMapping(value = "/verifyName.action")
	public String verifyName(User u) {
		User user = vms.selName(u);
		if(user!=null) {
			return JSON.toJSONString(false);
		}else {
			return JSON.toJSONString(true);
		}
	}
	
	@RequestMapping(value = "/verifyIdcard.action")
	public String verifyIdcard(User u) {
		User user = vms.selIdcard(u);
		if(user!=null) {
			return JSON.toJSONString(false);
		}else {
			return JSON.toJSONString(true);
		}
	}
	
	@RequestMapping(value = "/verifyPhone.action")
	public String verifyPhone(User u) {
		User user = vms.selPhone(u);
		if(user!=null) {
			return JSON.toJSONString(false);
		}else {
			return JSON.toJSONString(true);
		}
	}
	@RequestMapping(value = "/verifyUsername.action")
	public String verifyUsername(User u) {
		User user = vms.selUsername(u);
		if(user!=null) {
			return JSON.toJSONString(false);
		}else {
			return JSON.toJSONString(true);
		}
	}
	@RequestMapping(value = "/addUser.action")
	public String addUser(User u,HttpServletRequest req,HttpSession session) {
		User user = (User) session.getAttribute("user");
		URole role = vms.selRole(user);
		String uor = req.getParameter("UOR");
		if(uor.equals("user")) {
			Integer addUser = vms.addUser(u);
			if(addUser>0) {
				return JSON.toJSONString(true);				
			}else {				
				return JSON.toJSONString(false);				
			}
		}else {
			Integer rid = role.getRid();
			if(rid==3 || rid==4 || rid==5) {
				String pos = req.getParameter("pos");
				if(pos!=null && !"".equals(pos)) {
					Integer pos1 = Integer.parseInt(pos);
					Integer i= vms.addStaff(u,pos1);
					if(i>0) {
						return JSON.toJSONString(true);
					}else {
						return JSON.toJSONString(false);
					}
				}else {
					Integer i = vms.addUser(u);
					if(i>0) {
						return JSON.toJSONString(true);
					}else {
						return JSON.toJSONString(false);
					}	
				}
			}else {
				return JSON.toJSONString(false);
			}
		}
	}
}
