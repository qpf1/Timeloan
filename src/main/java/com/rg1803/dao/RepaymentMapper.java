package com.rg1803.dao;

import java.util.List;

import com.rg1803.pojo.AllLoan;
import com.rg1803.pojo.Loan;
import com.rg1803.pojo.Repayment;
import com.rg1803.pojo.URate;
import com.rg1803.pojo.User;
import com.rg1803.pojo.UserVo;

public interface RepaymentMapper {

	List<AllLoan> showRepay(UserVo vo);
	Integer selcount(UserVo vo);
	
	Integer updateLoanstate(Loan ln);
	Repayment selrep(Loan ln);
	
	AllLoan showloan(User u);
	
	Integer weihuanqing(Repayment rp);
	Integer huanqing(Repayment rp);
	
	URate seljifen(URate ur);
	Integer addjifen(URate ur);
	Integer jianjifen(URate ur);
	Integer updateloanRate(URate ur);
	
	Integer updatestate(AllLoan al);
}
