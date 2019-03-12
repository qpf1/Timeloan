package com.rg1803.service;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.rg1803.dao.ShowLoanMapper;
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

@Service
public class ShowLoanServiceImpl implements ShowLoanService {
	
	@Autowired
	private ShowLoanMapper slm;

	public String showLoan(UserVo vo) {
		List<AllLoan> list = slm.showloan(vo);
		for(AllLoan al:list) {
			Date loanDate = al.getLoanDate();
			Date loanStartDate = al.getLoanStartDate();
			Date loanEndDate = al.getLoanEndDate();
			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
			if(loanDate!=null) {
				al.setLoanData(ft.format(loanDate));
			}
			if(loanStartDate!=null) {
				al.setLoanStartData(ft.format(loanStartDate));
			}
			if(loanEndDate!=null) {
				al.setLoanEndData(ft.format(loanEndDate));	
			}
		}
		Integer count = slm.loanCount(vo);
		HashMap<Object, Object> map = new HashMap<>();
		map.put("total", count);
		map.put("rows",list);
		return JSON.toJSONString(map);
	}

	public AllLoan haveLoan(User user) {
		AllLoan loan = slm.haveLoan(user);
		return loan;
	}

	public URate selrate(User u) {
		URate rate = slm.selrate(u);
		return rate;
	}

	public User selUser(User u) {
		User user = slm.selUser(u);
		return user;
	}

	public boolean addLoan(Loan ln,User u) throws ParseException {
		User user = selUser(u);
		Integer id = user.getId();
		ln.setUid(id);
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		String format = ft.format(date);
		Date parse = ft.parse(format);
		ln.setLoanDate(parse);
		ln.setLoanCode(String.valueOf(date.getTime()));
		ln.setLoanstate(0);
		Integer i = slm.addLoan(ln);
		if(i>0) {
			Loan loan = slm.selLoan(ln);
			Integer i2 = slm.addWorkflow(loan);
			WorkFlowNode wfn = slm.selwfn(loan);
			LoanType lt = slm.selnode(loan);
			String node = lt.getNode();			
			wfn.setNownode(node.substring(0, 1));
			Integer w = slm.addworkflownode(wfn);
			if(i2>0 && w>0) {
				return true;			
			}else {
				return false;
			}
		}else {
			return false;
		}
	}

	public Loan selLoanById(Loan ln) {
		Loan loan = slm.selLoanById(ln);
		return loan;
	}

	public boolean updateLoan(Loan ln) {
		Integer i = slm.updateLoan(ln);
		Loan loan = slm.selLoanByUId(ln);
		WorkFlow workFlow = slm.selwk(loan);
		LoanType loanType = slm.selnode(loan);
		String node = loanType.getNode();
		loanType.setNownode(node.substring(0, 1));
		loanType.setWid(workFlow.getId());
		Integer ufi = slm.updateworkflownode(loanType);
		if(i>0 && ufi>0 ) {
			return true;
		}else {
			return false;
		}
	}

	public boolean delLoan(Loan ln) {
		Integer delLoan = slm.delLoan(ln);
		Repayment rp = new Repayment();
		rp.setLid(ln.getId());
		Integer delrepay = slm.delrepay(rp);
		Integer delworkflow = slm.delworkflow(ln);
		LoanType loanType = slm.selnode(ln);
		loanType.setWid(ln.getId());
		Integer dfwn = slm.delworkflownode(loanType);
		if(delLoan>0 && delworkflow>0 && dfwn>0 && delrepay>0) {
			return true;
		}else {
			return false;
		}
		
	}

	public Role selRoleByUser(User u) {
		Role role = slm.selRoleByUser(u);
		return role;
	}

	public WorkFlowNode selFlowNodeByLoan(Loan ln) {
		WorkFlowNode workFlowNode = slm.selwfn(ln);
		return workFlowNode;
	}

	public User selUserbyUid(Loan ln) {
		User user = slm.selUserbyUid(ln);
		return user;
	}

	public WorkFlow selFlowByLoan(Loan ln) {
		WorkFlow wf = slm.selwk(ln);
		return wf;
	}

	
	public boolean addwfl(WorkFlowLog wfl,Loan ln) throws ParseException {
		Integer i = slm.addwfl(wfl);
		Integer uls = slm.updateloanstateByloanid(ln);
		WorkFlowNode wfn = slm.selwfn(ln);
		String node = wfn.getNode();
		String[] n = node.split(",");
		String nownode = wfn.getNownode();
		String con = "";
		if(!n[n.length-1].equals(nownode)) {
			for(int j=0;j<n.length;j++) {				
				if(nownode.equals(n[j])) {
					//就将节点传到下一节点
					con = n[j+1];
				}
			}
			
		}else {
			con="";
		}
		// 将下一节点值更新
		
		if(con!=null && !"".equals(con)) {
			WorkFlowNode wfnb = slm.selWorkFlowNodeByLoan(ln);
			wfnb.setNownode(con);
			Integer un = slm.updateNownode(wfnb);
			if(i>0 && uls>0 && un>0) {
				return true;
			}else {
				return false;
			}
		}else {
			Date date = new Date();
			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
			String format = ft.format(date);
			Date parse = ft.parse(format);
			ln.setLoanStartDate(parse);
			Integer loanStart = slm.loanStart(ln);
			WorkFlowNode wfnb = slm.selWorkFlowNodeByLoan(ln);
			wfnb.setNownode(con);
			Integer un = slm.updateNownode(wfnb);
			Loan loan = slm.selLoanById(ln);
			Integer loanDay = loan.getLoanDay();
			Calendar ca = Calendar.getInstance();  
	        ca.add(Calendar.DATE, loanDay);// 30为增加的天数，可以改变的  
	        Date endDay = ca.getTime();  
	        loan.setLoanEndDate(endDay);
	        Integer loanEndDay = slm.loanEndDay(loan);
	        Integer loanstate = slm.Loanstate(loan);
	        Integer updateworkflow = slm.updateworkflow(loan);
	        
	        Repayment rp = new Repayment();
			rp.setLid(loan.getId());
			rp.setRepaymoney(0.0);
			rp.setRepaystate(0);
			Integer day = loan.getLoanDay();
			Double loanSum = loan.getLoanSum();
			Double loanRate = loan.getLoanRate();
			for (int j = 0; j < day; j++) {
				loanSum = loanSum*loanRate+loanSum;
			}
			loanSum= (double) Math.round(loanSum * 100) / 100;
			rp.setAllsum(loanSum);
			Integer addRepay = slm.addRepay(rp);
			if(loanStart>0 && un>0 &&loanEndDay>0 && loanstate>0 && updateworkflow>0 && addRepay>0) {
				return true;
			}else {
				return false;
			}
		}
	}

	public String showloanBylevel(User u) {
		Role role = slm.selRoleByUser(u);
		List<WorkFlowNode> wfn = slm.selLoanbylevel(role);
		HashMap<Object, Object> map = new HashMap<>();
		if(wfn!=null&&wfn.size()>0) {
			ArrayList<Integer> list = new ArrayList<>();
			for(WorkFlowNode wf:wfn) {
				Integer id = wf.getWid();
				list.add(id);
			}
			List<AllLoan> aloan = slm.showloanBylevel(list);
			for(AllLoan al:aloan) {
				Date loanDate = al.getLoanDate();
				SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
				if(loanDate!=null) {
					al.setLoanData(ft.format(loanDate));
				}
			}
			Integer count = slm.selcount(role);
			map.put("total", count);
			map.put("rows",aloan);
			return JSON.toJSONString(map);
		}else {
			map.put("total", 0);
			return JSON.toJSONString(map);
		}
	}

	public Boolean refuseloan(WorkFlowLog wfl, Loan ln) {
		Integer i = slm.addwfl(wfl);
		Integer uls = slm.updateloanstateByloanid(ln);
		WorkFlowNode wfnb = slm.selWorkFlowNodeByLoan(ln);
		String con="";
		wfnb.setNownode(con);
		Integer un = slm.updateNownode(wfnb);
		Integer rwf = slm.refuseworkflow(ln);
		Loan loan = slm.selLoanById(ln);
		Integer loanstate = slm.Loanstate(loan);
		if(i>0 && uls>0 && un>0 && rwf>0 && loanstate>0) {
			return true;
		}else {
			return false;
		}
	}

}
