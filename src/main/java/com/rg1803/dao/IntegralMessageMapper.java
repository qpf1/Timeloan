package com.rg1803.dao;

import java.util.List;

import com.rg1803.pojo.AllLoan;
import com.rg1803.pojo.UserVo;

public interface IntegralMessageMapper {

	List<AllLoan> showjifenlist(UserVo vo);
	Integer jifencount(UserVo vo);
}
