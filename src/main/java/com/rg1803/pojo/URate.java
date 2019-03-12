package com.rg1803.pojo;

import java.io.Serializable;

public class URate implements Serializable{

	/**
	 * 用户和利率表对象
	 */
	private static final long serialVersionUID = -1632210524579232693L;
	private Integer id;
	private String username;
	private String password;
	private Integer state;
	private String realname;
	private String idcard;
	private String phone;
	private Integer isemp;
	private Integer uid;
	private Double loanRate;
	private Integer integral;
	
	public Integer getIntegral() {
		return integral;
	}
	public void setIntegral(Integer integral) {
		this.integral = integral;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getIsemp() {
		return isemp;
	}
	public void setIsemp(Integer isemp) {
		this.isemp = isemp;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Double getLoanRate() {
		return loanRate;
	}
	public void setLoanRate(Double loanRate) {
		this.loanRate = loanRate;
	}
}
