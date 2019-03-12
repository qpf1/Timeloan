package com.rg1803.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rg1803.dao.VerifyMessageMapper;
import com.rg1803.pojo.URole;
import com.rg1803.pojo.User;

@Service
public class VerifyMessageServiceImpl implements VerifyMessageService {

	@Autowired
	private VerifyMessageMapper vmm;
	
	public User selName(User u) {//查询姓名是否重复
		User user = vmm.selName(u);
		return user;
	}
	public User selIdcard(User u) {//查询身份证是否重复
		User user = vmm.selIdcard(u);
		return user;
	}
	public User selPhone(User u) {//查询手机号是否重复
		User user = vmm.selPhone(u);
		return user;
	}
	public User selUsername(User u) {
		User user = vmm.selUsername(u);
		return user;
	}
	
	public Integer addUser(User u) {
		Integer us = vmm.addUser(u);
		if(us>0) {
			User user = vmm.selIdcard(u);
			Integer id = user.getId();
			Integer i = vmm.addUT(id);
			return i;
		}
		return 0;
	}
	public Integer addStaff(User u, Integer pos) {
		Integer as = vmm.addStaff(u);
		if(as>0) {
			User user = vmm.selIdcard(u);
			Integer id = user.getId();
			Integer i = vmm.addUR(id,pos);
			return i;
		}
		return 0;
	}
	public URole selRole(User u) {
		URole role = vmm.selRole(u);
		return role;
	}

}
