package com.rg1803.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.rg1803.dao.RepaymentMapper;
import com.rg1803.dao.ShowLoanMapper;
import com.rg1803.pojo.AllLoan;
import com.rg1803.pojo.Loan;
import com.rg1803.pojo.Repayment;
import com.rg1803.pojo.URate;
import com.rg1803.pojo.User;
import com.rg1803.pojo.UserVo;

@Service
public class RepaymentServiceImpl implements RepaymentService {

	@Autowired
	private RepaymentMapper rmm;
	
	
	
	@Autowired
	private ShowLoanMapper slm;
	

	public String showRepay(UserVo vo) {
		List<AllLoan> list = rmm.showRepay(vo);
		for (AllLoan al : list) {
			Date loanStartDate = al.getLoanStartDate();
			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
			if(loanStartDate!=null) {
				al.setLoanStartData(ft.format(loanStartDate));
			}
			if(al.getRepaystate()!=2) {
				Date loanEndDate = al.getLoanEndDate();
				if(loanEndDate!=null) {
					long time2 = loanEndDate.getTime();
					Date date = new Date();// 当前时间
					long time = date.getTime();
					if(time2 > time) {
						al.setRepaystate(3);
						rmm.updatestate(al);
					}	
				}
			}
		}
		
		Integer count = rmm.selcount(vo);
		HashMap<Object,Object> map = new HashMap<>();
		map.put("total", count);
		map.put("rows",list);
		return JSON.toJSONString(map);
	}


	public String huanqian(User u) {
		Loan loan = new Loan();
		loan.setUid(u.getId());
		Loan ln = slm.selLoanByUId(loan);
		Repayment rp = rmm.selrep(ln);
		ln.setAllsum(rp.getAllsum());
		Integer i = rmm.updateLoanstate(ln);
		if(i>0) {
			return JSON.toJSONString(true);
		}else {
			return JSON.toJSONString(false);
		}
	}

	public String cheackmoney(User u) {
		Loan loan = new Loan();
		loan.setUid(u.getId());
		List<Loan> ln = slm.selallLoanByUId(loan);
		boolean bo=false;
			for (Loan la : ln) {
				if(la.getLoanstate()==2) {
					Repayment rp = rmm.selrep(la);
					double dis=1e-6;
					if(Math.abs(rp.getRepaymoney()-rp.getAllsum())<dis) {
						bo=true;
					}else {
						bo=false;
					}	
				}
			}	
			return JSON.toJSONString(bo);
	}

	public AllLoan showloan(User u) {
		AllLoan al = rmm.showloan(u);
		return al;
	}

	public Integer weihuanqing(Repayment rp) {
		Integer i = rmm.weihuanqing(rp);
		return i;
	}

	public Integer huanqing(Repayment rp) {
		Integer i = rmm.huanqing(rp);
		return i;
	}
	
	public String addjifen(Loan ln) {
		Loan loan = slm.selLoanById(ln);
		URate ur = new URate();
		ur.setUid(loan.getUid());
		URate urate = rmm.seljifen(ur);
		Integer jifen = urate.getIntegral()+5;
		urate.setIntegral(jifen);
		Integer i = rmm.addjifen(urate);
		if(i>0) {
			if(jifen>=90) {
				urate.setLoanRate(0.0009);
				Integer updateloanRate = rmm.updateloanRate(urate);
				if(updateloanRate >0) {
					return JSON.toJSONString(true);
				}else {
					return JSON.toJSONString(false);
				}
			}else if(jifen <90 && jifen >=80) {
				urate.setLoanRate(0.0011);
				Integer updateloanRate = rmm.updateloanRate(urate);
				if(updateloanRate >0) {
					return JSON.toJSONString(true);
				}else {
					return JSON.toJSONString(false);
				}
			}else if(jifen <80 && jifen>=70) {
				urate.setLoanRate(0.0012);
				Integer updateloanRate = rmm.updateloanRate(urate);
				if(updateloanRate >0) {
					return JSON.toJSONString(true);
				}else {
					return JSON.toJSONString(false);
				}
			}else if(jifen <70 && jifen>=60) {
				urate.setLoanRate(0.0013);
				Integer updateloanRate = rmm.updateloanRate(urate);
				if(updateloanRate >0) {
					return JSON.toJSONString(true);
				}else {
					return JSON.toJSONString(false);
				}
			}
		}
		return JSON.toJSONString(false);
		
	}


	public String jianjifen(Loan ln) {
		Loan loan = slm.selLoanById(ln);
		URate ur = new URate();
		ur.setUid(loan.getUid());
		URate urate = rmm.seljifen(ur);
		Integer jifen = urate.getIntegral()-5;
		urate.setIntegral(jifen);
		Integer i = rmm.addjifen(urate);
		if(i>0) {
			if(jifen>=90) {
				urate.setLoanRate(0.0009);
				Integer updateloanRate = rmm.updateloanRate(urate);
				if(updateloanRate >0) {
					return JSON.toJSONString(true);
				}else {
					return JSON.toJSONString(false);
				}
			}else if(jifen <90 && jifen >=80) {
				urate.setLoanRate(0.0011);
				Integer updateloanRate = rmm.updateloanRate(urate);
				if(updateloanRate >0) {
					return JSON.toJSONString(true);
				}else {
					return JSON.toJSONString(false);
				}
			}else if(jifen <80 && jifen>=70) {
				urate.setLoanRate(0.0012);
				Integer updateloanRate = rmm.updateloanRate(urate);
				if(updateloanRate >0) {
					return JSON.toJSONString(true);
				}else {
					return JSON.toJSONString(false);
				}
			}else if(jifen <70 && jifen>=60) {
				urate.setLoanRate(0.0013);
				Integer updateloanRate = rmm.updateloanRate(urate);
				if(updateloanRate >0) {
					return JSON.toJSONString(true);
				}else {
					return JSON.toJSONString(false);
				}
			}
		}
		return JSON.toJSONString(false);
	}
}
