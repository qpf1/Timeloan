package com.rg1803.service;

import com.rg1803.pojo.User;

public interface LoginService {

	Boolean login(User u);
	Integer agree(User u);
}
