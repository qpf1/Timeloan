package com.rg1803.pojo;

import java.io.Serializable;
import java.util.Date;

public class Loan implements Serializable{

	/**
	 * 贷款对象
	 */
	private static final long serialVersionUID = 1780870158534239668L;
	private Integer id;
	private Double loanSum;
	private Double loanRate;
	private Date loanDate;
	private String loansubmitDate;
	private Date loanStartDate;
	private Date loanEndDate;
	private Integer loanDay;
	private Integer uid;
	private Integer loanstate;
	private Integer loantype;
	private String loanCode;
	private Double allsum;
	public Double getAllsum() {
		return allsum;
	}
	public void setAllsum(Double allsum) {
		this.allsum = allsum;
	}
	public String getLoansubmitDate() {
		return loansubmitDate;
	}
	public void setLoansubmitDate(String loansubmitDate) {
		this.loansubmitDate = loansubmitDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getLoanSum() {
		return loanSum;
	}
	public void setLoanSum(Double loanSum) {
		this.loanSum = loanSum;
	}
	public Double getLoanRate() {
		return loanRate;
	}
	public void setLoanRate(Double loanRate) {
		this.loanRate = loanRate;
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
	public void setLoanStartDate(Date loanStartdDate) {
		this.loanStartDate = loanStartdDate;
	}
	public Date getLoanEndDate() {
		return loanEndDate;
	}
	public void setLoanEndDate(Date loanEndDate) {
		this.loanEndDate = loanEndDate;
	}
	public Integer getLoanDay() {
		return loanDay;
	}
	public void setLoanDay(Integer loanDay) {
		this.loanDay = loanDay;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getLoanstate() {
		return loanstate;
	}
	public void setLoanstate(Integer loanstate) {
		this.loanstate = loanstate;
	}
	public Integer getLoantype() {
		return loantype;
	}
	public void setLoantype(Integer loantype) {
		this.loantype = loantype;
	}
	public String getLoanCode() {
		return loanCode;
	}
	public void setLoanCode(String loanCode) {
		this.loanCode = loanCode;
	}
}
