package com.rg1803.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.rg1803.pojo.AllLoan;
import com.rg1803.pojo.Loan;
import com.rg1803.pojo.Repayment;
import com.rg1803.pojo.User;
import com.rg1803.pojo.UserVo;
import com.rg1803.service.RepaymentService;
import com.rg1803.service.ShowLoanService;

@Controller
@ResponseBody
public class RepaymentController {

	@Autowired
	private RepaymentService rms;
	
	@Autowired
	private ShowLoanService sls;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value = "/showRepay.action")
	public String showRepay(UserVo vo) {
		User user = (User) session.getAttribute("user");
		vo.setUser(user);
		return rms.showRepay(vo);
	}
	
	@RequestMapping(value = "/addjifen.action")
	public String addjifen(Loan ln) {
		return rms.addjifen(ln);
	}
	@RequestMapping(value = "/jianjifen.action")
	public String jianjifen(Loan ln) {
		return rms.jianjifen(ln);
	}
	
	@RequestMapping(value = "/huanqian.action")
	public String huanqian() {
		User user = (User) session.getAttribute("user");
		return rms.huanqian(user);
	}
	
	@RequestMapping(value="/cheackmoney.action")
	public String cheackmoney() {
		User user = (User) session.getAttribute("user");
		return rms.cheackmoney(user);
	}
	
	@RequestMapping(value = "/loanmes.action")
	public String loanmes() {
		User user = (User) session.getAttribute("user");
		AllLoan loan = rms.showloan(user);
		return JSON.toJSONString(loan);
	}
	
	@RequestMapping(value = "/verifySum.action")
	public String verifyDay() {
		User user = (User) session.getAttribute("user");
		AllLoan loan = rms.showloan(user);
		HashMap<Object, Object> map = new HashMap<>();
		if(loan.getLoanSum()>5000) {
			map.put("bo", true);
			map.put("loan", loan);
			return JSON.toJSONString(map);
		}else {
			map.put("bo", false);
			return JSON.toJSONString(map);
		}
	}
	
	@RequestMapping(value = "fenpihuan.action")
	public String fenpihuan(Repayment rp) {
		User user = (User) session.getAttribute("user");
		AllLoan loan1 = rms.showloan(user);
		Loan ln = new Loan();
		ln.setId(loan1.getId());
		Loan loan = sls.selLoanById(ln);
		if(Math.abs(loan1.getAllsum()-rp.getRepaymoney())<=0) {
			rms.addjifen(loan);
		}
		Double repaymoney = rp.getRepaymoney();
		Double allsum = loan1.getAllsum();
		rp.setLid(loan.getId());
		if(Double.doubleToLongBits(repaymoney) < Double.doubleToLongBits(allsum-repaymoney)) {
			rp.setRepaymoney(rp.getRepaymoney()+loan1.getRepaymoney());
			Integer i = rms.weihuanqing(rp);
			if(i>0) {
				return JSON.toJSONString(true);
			}else {
				return JSON.toJSONString(false);
			}
		}else if(Double.doubleToLongBits(repaymoney) >= Double.doubleToLongBits(allsum-repaymoney)){
			rp.setRepaymoney(loan1.getAllsum());
			Integer i = rms.huanqing(rp);
			if(i>0) {
				return JSON.toJSONString(true);
			}else {
				return JSON.toJSONString(false);
			}
		}
		return JSON.toJSONString(false);
	}
}
