package com.rg1803.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.rg1803.pojo.AllLoan;
import com.rg1803.pojo.Loan;
import com.rg1803.pojo.Role;
import com.rg1803.pojo.URate;
import com.rg1803.pojo.User;
import com.rg1803.pojo.UserVo;
import com.rg1803.pojo.WorkFlow;
import com.rg1803.pojo.WorkFlowLog;
import com.rg1803.pojo.WorkFlowNode;
import com.rg1803.service.ShowLoanService;


@Controller
@ResponseBody
public class ShowLoanController {
	@Autowired
	private ShowLoanService sls;
	
	@RequestMapping(value = "/showLoan.action")
	public String showLoan(HttpServletRequest req,HttpSession session) {
		User user = (User) session.getAttribute("user");
		UserVo vo = new UserVo();
		vo.setName(req.getParameter("name"));
		vo.setIdcard(req.getParameter("idcard"));
		vo.setSel(req.getParameter("sel"));
		vo.setPageNumber(Integer.parseInt(req.getParameter("pageNumber")));
		vo.setPageSize(Integer.parseInt(req.getParameter("pageSize")));
		vo.setUser(user);
		return sls.showLoan(vo);
	}
	
	@RequestMapping(value = "/startLoan.action")
	public String startLoan(HttpSession session) {
		User user = (User) session.getAttribute("user");
		Integer isemp = user.getIsemp();
		HashMap<Object,Object> map = new HashMap<>();
		if(isemp!=null) {
			map.put("bo", false);
			map.put("cn", 1);//cn==1  表示是内部员工
			return JSON.toJSONString(map);
		}else {
			URate uRate = sls.selrate(user);
			if(uRate.getIntegral()>60) {
				AllLoan loan = sls.haveLoan(user);
				Double loanRate = uRate.getLoanRate();
				if(loan!=null) {
					if( loan.getRepaystate()==2) {
						Integer loanstate = loan.getLoanstate();
						if(loanstate ==2 || loanstate ==3) {
							map.put("bo", true);
							map.put("user", user);
							map.put("loanRate", loanRate);
							return JSON.toJSONString(map);
						}else {
							map.put("bo", false);
							map.put("cn", 2);//cn==2表示已经有贷款在审核
							return JSON.toJSONString(map);	
						}	
					}else {
						map.put("bo", false);
						map.put("cn", 3);//cn==3表示有贷款未还清
						return JSON.toJSONString(map);	
					}
				}else {
					map.put("bo", true);
					map.put("user", user);
					map.put("loanRate", loanRate);
					return JSON.toJSONString(map);
				}
			}else {
				map.put("bo", false);
				map.put("cn", 4);//cn==4表示信誉积分小于60 不能贷款
				return JSON.toJSONString(map);
			}
		}
	}
	
	@RequestMapping(value = "/lauchLoan.action")
	public String lauchLoan(Loan ln,HttpSession httpSession){
		User u = (User)httpSession.getAttribute("user");
		boolean i;
		try {
			i = sls.addLoan(ln, u);
			if(i) {
				return JSON.toJSONString(true);
			}else {
				return JSON.toJSONString(false);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/cheackemp.action")
	public String cheackemp(HttpSession session) {
		User user = (User) session.getAttribute("user");
		Integer isemp = user.getIsemp();
		if(isemp!=null) {
			return JSON.toJSONString(true);
		}else {
			return JSON.toJSONString(false);
		}
	}
	
	@RequestMapping(value = "/updateLoan.action")
	public String updateLoan(Loan ln,HttpSession session) {
		User user = (User) session.getAttribute("user");
		Integer isemp = user.getIsemp();
		HashMap<Object, Object> map = new HashMap<>();
		if(isemp!=null) {
			map.put("bo", false);
			map.put("cn", 1);//cn==1  表示是内部员工
			return JSON.toJSONString(map);
		}else {
			Loan loan = sls.selLoanById(ln);
			Integer state = loan.getLoanstate();
			if(state==0) {
				map.put("user", user);
				map.put("loan", loan);
				map.put("bo", true);
				return JSON.toJSONString(map);
			}else if(state ==1){
				map.put("bo", false);
				map.put("cn", 2);//cn==2表示已经有贷款在审核
				return JSON.toJSONString(map);
			}else if(state==2) {
				map.put("bo", false);
				map.put("cn", 3);//cn==3表示该贷款已经审批完成了
				return JSON.toJSONString(map);
			}
		}
		return null;
	}
	
	@RequestMapping(value = "/updateStart.action")
	public String updateStart(Loan ln,HttpSession session) {
		User user = (User) session.getAttribute("user");
		Integer id = user.getId();
		ln.setUid(id);
		boolean i = sls.updateLoan(ln);
		if(i) {
			return JSON.toJSONString(true);
		}else {
			return JSON.toJSONString(false);
		}
	}
	
	@RequestMapping(value = "/delLoan.action")
	public String delLoan(Loan ln,HttpSession session) {
		User user = (User) session.getAttribute("user");
		Integer isemp = user.getIsemp();
		HashMap<Object,Object> map = new HashMap<>();
		if(isemp!=null) {
			map.put("bo", false);
			map.put("cn", 1);//cn==1表示内部员工
			return JSON.toJSONString(map);
		}else {
			Loan loan = sls.selLoanById(ln);
			Integer loanstate = loan.getLoanstate();
			if(loanstate==0) {
				boolean delLoan = sls.delLoan(loan);
				if(delLoan) {
					map.put("bo", true);
					return JSON.toJSONString(map);
				}else {
					map.put("bo", false);
					return JSON.toJSONString(map);
				}
			}else if(loanstate ==1){
				map.put("bo", false);
				map.put("cn", 2);//cn==2表示已经有贷款在审核
				return JSON.toJSONString(map);
			}else if(loanstate==2) {
				map.put("bo", false);
				map.put("cn", 3);//cn==3表示该贷款已经审批完成了
				return JSON.toJSONString(map);
			}
		}
		return null;	
	}
	
	@RequestMapping(value = "/queryLoanTask.action")
	public String QueryLoanTask(HttpSession session,Loan ln) {
		User user = (User) session.getAttribute("user");
		Role role = sls.selRoleByUser(user);
		Integer level = role.getLevel();
		Loan loan = sls.selLoanById(ln);
		WorkFlowNode wfn = sls.selFlowNodeByLoan(loan);
		Integer startnode = Integer.parseInt(wfn.getNownode());
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		String format = ft.format(loan.getLoanDate());
		loan.setLoansubmitDate(format);
		HashMap<Object,Object> map = new HashMap<>();
		Integer loanstate = loan.getLoanstate();
		if(loanstate == 0) {
			if(level == startnode) {
				User u = sls.selUserbyUid(loan);
				map.put("bo", true);
				map.put("loan", loan);
				map.put("user", u);
				return JSON.toJSONString(map);
			}else {
				map.put("bo", false);
				return JSON.toJSONString(map);
			}	
		}else{
			if(level==startnode) {
				User u = sls.selUserbyUid(loan);
				map.put("bo", true);
				map.put("loan", loan);
				map.put("user", u);
				return JSON.toJSONString(map);
			}else {
				map.put("bo", false);
				return JSON.toJSONString(map);
			}
		}
	}
	
	
	
	@RequestMapping(value = "/spagree.action")
	public String spagree(Loan ln,String option,HttpSession session) {
		WorkFlow wf = sls.selFlowByLoan(ln);
		User user = (User) session.getAttribute("user");
		Role role = sls.selRoleByUser(user);
		WorkFlowLog wfl = new WorkFlowLog();
		wfl.setOption(option);
		wfl.setWid(wf.getId());
		wfl.setSpman(user.getRealname());
		wfl.setSprole(role.getRole());
		wfl.setWorkdate(new Date());
		try {
			boolean b = sls.addwfl(wfl, ln);
			if(b) {
				return JSON.toJSONString(true);
			}else {
				return JSON.toJSONString(false);
			}		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return JSON.toJSONString(false);
	}
	
	@RequestMapping(value = "/cheacklevel.action")
	public String cheacklevel(HttpSession session,Loan ln) {
		User user = (User) session.getAttribute("user");
		Role role = sls.selRoleByUser(user);
		if(role!=null) {
			ln.setUid(user.getId());
			Loan loan = sls.selLoanById(ln);
			WorkFlowNode wfn = sls.selFlowNodeByLoan(loan);
			Integer nownode = Integer.parseInt(wfn.getNownode());
			if(nownode==role.getLevel()) {
				return JSON.toJSONString(true);
			}else {
				return JSON.toJSONString(false);
			}	
		}else {
			return JSON.toJSONString(false);
		}
	}
	
	@RequestMapping(value = "/spLoan.action")
	public String spLoan(HttpSession session) {
		User user = (User) session.getAttribute("user");
		String json = sls.showloanBylevel(user);
		return json;
	}
	
	@RequestMapping(value = "/refuse.action")
	public String refuse(HttpSession session,Loan ln,String option) {
		WorkFlow wf = sls.selFlowByLoan(ln);
		User user = (User) session.getAttribute("user");
		Role role = sls.selRoleByUser(user);
		WorkFlowLog wfl = new WorkFlowLog();
		wfl.setOption(option);
		wfl.setWid(wf.getId());
		wfl.setSpman(user.getRealname());
		wfl.setSprole(role.getRole());
		wfl.setWorkdate(new Date());
		Boolean refuseloan = sls.refuseloan(wfl, ln);
		if(refuseloan) {
			return JSON.toJSONString(true);
		}else {
			return JSON.toJSONString(false);	
		}
	}
	
	@RequestMapping(value = "/checkloginUser.action")
	public String checkloginUser(HttpSession session) {
		User user = (User) session.getAttribute("user");
		Role role = sls.selRoleByUser(user);
		HashMap<Object,Object> map = new HashMap<>();
		if(user!=null) {
			map.put("user", user);
			map.put("role", role);
			map.put("bo", true);
			return JSON.toJSONString(map);
		}else {
			map.put("bo", false);
			return JSON.toJSONString(map);
		}
	}
}
