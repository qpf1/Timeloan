package com.rg1803.dao;

import com.rg1803.pojo.User;

public interface LoginMapper {

	User login(User user);
	Integer agree(Integer id);
}
