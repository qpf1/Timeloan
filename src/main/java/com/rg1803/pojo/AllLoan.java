package com.rg1803.pojo;

import java.io.Serializable;
import java.util.Date;

public class AllLoan implements Serializable{

	/**
	 *贷款列表对象
	 */
	private static final long serialVersionUID = -2935365710606956950L;
	private Integer id;
	private String realname;
	private String idcard;
	private String loanCode;
	private Double loanSum;
	private Date loanDate;//发起贷款的日期
	private Date loanStartDate;//贷款开始的日期
	private Date loanEndDate;//贷款结束的日期
	private String loanData;//发起贷款的日期          yyyy-MM-dd
	private String loanStartData;//贷款开始的日期  yyyy-MM-dd
	private String loanEndData;//贷款结束的日期   yyyy-MM-dd
	private Double loanRate;
	private Integer loanDay;
	private String type;
	private Integer loanstate;
	private Integer state;
	private Integer isemp;
	private Integer  repaystate;//还款状态
	private Double allsum;//本息
	private Double repaymoney;
	private Integer integral;
	
	
	
	public Integer getIntegral() {
		return integral;
	}
	public void setIntegral(Integer integral) {
		this.integral = integral;
	}
	public Double getRepaymoney() {
		return repaymoney;
	}
	public void setRepaymoney(Double repaymoney) {
		this.repaymoney = repaymoney;
	}
	public Double getAllsum() {
		return allsum;
	}
	public void setAllsum(Double allsum) {
		this.allsum = allsum;
	}
	
	public Integer getRepaystate() {
		return repaystate;
	}
	public void setRepaystate(Integer repaystate) {
		this.repaystate = repaystate;
	}
	public Integer getIsemp() {
		return isemp;
	}
	public void setIsemp(Integer isemp) {
		this.isemp = isemp;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getLoanData() {
		return loanData;
	}
	public void setLoanData(String loanData) {
		this.loanData = loanData;
	}
	public String getLoanStartData() {
		return loanStartData;
	}
	public void setLoanStartData(String loanStartData) {
		this.loanStartData = loanStartData;
	}
	public String getLoanEndData() {
		return loanEndData;
	}
	public void setLoanEndData(String loanEndData) {
		this.loanEndData = loanEndData;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getLoanCode() {
		return loanCode;
	}
	public void setLoanCode(String loanCode) {
		this.loanCode = loanCode;
	}
	public Double getLoanSum() {
		return loanSum;
	}
	public void setLoanSum(Double loanSum) {
		this.loanSum = loanSum;
	}
	public Date getLoanDate() {
		return loanDate;
	}
	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}
	public Date getLoanStartDate() {
		return loanStartDate;
	}
	public void setLoanStartDate(Date loanStartDate) {
		this.loanStartDate = loanStartDate;
	}
	public Date getLoanEndDate() {
		return loanEndDate;
	}
	public void setLoanEndDate(Date loanEndDate) {
		this.loanEndDate = loanEndDate;
	}
	public Double getLoanRate() {
		return loanRate;
	}
	public void setLoanRate(Double loanRate) {
		this.loanRate = loanRate;
	}
	public Integer getLoanDay() {
		return loanDay;
	}
	public void setLoanDay(Integer loanDay) {
		this.loanDay = loanDay;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getLoanstate() {
		return loanstate;
	}
	public void setLoanstate(Integer loanstate) {
		this.loanstate = loanstate;
	}
}
