package com.rg1803.pojo;

import java.io.Serializable;

public class Repayment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7509527121292425571L;
	private Integer id;
	private Integer lid;
	private Double repaymoney;
	private Double allsum;
	private Integer repaystate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
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
	
}
