package com.rg1803.dao;

import java.util.List;

import com.rg1803.pojo.AllLoan;
import com.rg1803.pojo.Loan;
import com.rg1803.pojo.LoanType;
import com.rg1803.pojo.Repayment;
import com.rg1803.pojo.Role;
import com.rg1803.pojo.URate;
import com.rg1803.pojo.User;
import com.rg1803.pojo.UserVo;
import com.rg1803.pojo.WorkFlow;
import com.rg1803.pojo.WorkFlowLog;
import com.rg1803.pojo.WorkFlowNode;

public interface ShowLoanMapper {

	//查询所有贷款信息
	List<AllLoan> showloan(UserVo vo);
	
	//查询贷款条数
	Integer loanCount(UserVo vo);
	
	//判断是否有贷款
	AllLoan haveLoan(User user);
	
	//查询当前用户的贷款利率
	URate selrate(User u);

	//通过姓名和身份证号查询user对象
	User selUser(User u);
	
	//通过loan对象的uid查询user对象信息
	User selUserbyUid(Loan ln);
	
	//添加贷款信息
	Integer addLoan(Loan ln);
	Integer addWorkflow(Loan ln);
	//查询贷款
	Loan selLoan(Loan ln);
	Loan selLoanById(Loan ln);
	Loan selLoanByUId(Loan ln);
	List<Loan> selallLoanByUId(Loan ln);
	
	//修改贷款信息
	Integer updateLoan(Loan ln);
	
	//删除贷款信息
	Integer delLoan(Loan ln);
	Integer delworkflow(Loan ln);
	
	WorkFlowNode selwfn(Loan ln);
	WorkFlow selwk(Loan ln);
	Integer addworkflownode(WorkFlowNode wfn);
	
	LoanType selnode(Loan ln);
	Integer updateworkflownode(LoanType lt);
	
	Integer delworkflownode(LoanType lt);
	//通过user查询当前登录员工的等级
	Role selRoleByUser(User u);
	//添加workflowlog表
	Integer addwfl(WorkFlowLog wfl);
	//修改loan表贷款状态
	Integer updateloanstateByloanid(Loan ln);
	//通过workflownode对象修改 nownode
	Integer updateNownode(WorkFlowNode wfn);
	WorkFlowNode selWorkFlowNodeByLoan(Loan loan);
	
	//贷款开始时间
	Integer loanStart(Loan ln);
	Integer loanEndDay(Loan ln);
	//审批完成改变贷款状态
	Integer Loanstate(Loan ln);
	//通过lnid更改贷款的状态
	Integer updateworkflow(Loan ln);
	Integer refuseworkflow(Loan ln);

	//通过节点（员工）等级查询 贷款信息
	List<AllLoan> showloanBylevel(List<Integer> ls);
	//通过nownode节点查询当前节点有多少贷款
	Integer selcount(Role rl);
	List<WorkFlowNode> selLoanbylevel(Role rl);
	//添加还款信息表
	Integer addRepay(Repayment rp);
	//修改还款信息
	Integer updateRepay(Repayment rp);
	Integer delrepay(Repayment rp);
}
