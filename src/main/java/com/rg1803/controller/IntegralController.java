package com.rg1803.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rg1803.pojo.User;
import com.rg1803.pojo.UserVo;
import com.rg1803.service.IntegralMessageService;

@Controller
@ResponseBody
public class IntegralController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private IntegralMessageService ims;
	
	@RequestMapping(value = "/jifenlist.action")
	public String showjifenlist(UserVo vo) {
		User user = (User) session.getAttribute("user");
		vo.setUser(user);
		return ims.showjifenlist(vo);
	}
	
}
