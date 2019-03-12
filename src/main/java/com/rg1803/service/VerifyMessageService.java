package com.rg1803.service;

import com.rg1803.pojo.URole;
import com.rg1803.pojo.User;

public interface VerifyMessageService {

		//查询名字是否重复
		User selName(User u);

		//查询身份证是否重复
		User selIdcard(User u);
		//查询手机号是否重复
		User selPhone(User u);
		//查询登录帐号是否重复
		User selUsername(User u);
		//新增用户
		Integer addUser(User u);
		//新增员工
		Integer addStaff(User u, Integer pos);
		//查询员工的职位
		URole selRole(User u);
}
