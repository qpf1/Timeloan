package com.rg1803.service;

import java.text.ParseException;
import java.util.List;

import com.rg1803.pojo.AllLoan;
import com.rg1803.pojo.Loan;
import com.rg1803.pojo.Role;
import com.rg1803.pojo.URate;
import com.rg1803.pojo.User;
import com.rg1803.pojo.UserVo;
import com.rg1803.pojo.WorkFlow;
import com.rg1803.pojo.WorkFlowLog;
import com.rg1803.pojo.WorkFlowNode;

public interface ShowLoanService {

	//查询所有贷款信息
	String showLoan(UserVo vo);
	//查询是否有贷款
	AllLoan haveLoan(User user);
	
	//查询当前用户的贷款利率
	URate selrate(User u);
	
	//通过姓名和身份证号查询user对象
	User selUser(User u);
	
	//通过loan对象的uid查询user对象信息
	User selUserbyUid(Loan ln);
	
	//添加贷款信息
	boolean addLoan(Loan ln,User u) throws ParseException;
	//查询贷款
	Loan selLoanById(Loan ln);
	//修改贷款信息
	boolean updateLoan(Loan ln);
	//删除贷款信息
	boolean delLoan(Loan ln);
	//通过user查询当前登录员工的等级
	Role selRoleByUser(User u);
	//通过loan查询贷款的审批流程
	WorkFlowNode selFlowNodeByLoan(Loan ln);
	//通过loan的id查询workflow对象
	WorkFlow selFlowByLoan(Loan ln);
	//添加workflowlog表
	boolean addwfl(WorkFlowLog wfl,Loan ln) throws ParseException;
	
	
	//通过节点（员工）等级查询 贷款信息
	String showloanBylevel(User u);
	//拒绝贷款
	Boolean refuseloan(WorkFlowLog wfl,Loan ln);
	
}
