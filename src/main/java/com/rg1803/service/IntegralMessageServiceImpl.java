package com.rg1803.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.rg1803.dao.IntegralMessageMapper;
import com.rg1803.pojo.AllLoan;
import com.rg1803.pojo.UserVo;

@Service
public class IntegralMessageServiceImpl implements IntegralMessageService {

	@Autowired
	private IntegralMessageMapper imm;

	public String showjifenlist(UserVo vo) {
		List<AllLoan> list = imm.showjifenlist(vo);
		Integer count = imm.jifencount(vo);
		HashMap<Object, Object> map = new HashMap<>();
		map.put("total", count);
		map.put("rows",list);
		return JSON.toJSONString(map);
	}
}
