package com.rg1803.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rg1803.dao.LoginMapper;
import com.rg1803.pojo.User;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper lm;

	@Override
	public Boolean login(User u) {
		User user = lm.login(u);
		if(user!=null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Integer agree(User u) {
		User user = lm.login(u);
		Integer id = user.getId();
		Integer i = lm.agree(id);
		return i;
	}
	
	
}
