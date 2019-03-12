package com.rg1803.service;


import com.rg1803.pojo.AllLoan;
import com.rg1803.pojo.Loan;
import com.rg1803.pojo.Repayment;
import com.rg1803.pojo.User;
import com.rg1803.pojo.UserVo;

public interface RepaymentService {

	String showRepay(UserVo vo);
	
	
	String huanqian(User u);
	String cheackmoney(User u);
	
	AllLoan showloan(User u);
	
	Integer weihuanqing(Repayment rp);
	Integer huanqing(Repayment rp);
	
	 String addjifen(Loan ln);


	String jianjifen(Loan ln);
}
