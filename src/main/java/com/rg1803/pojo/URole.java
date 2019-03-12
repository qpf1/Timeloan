package com.rg1803.pojo;

import java.io.Serializable;

public class URole implements Serializable{

	/**
	 * 用户表和用户员工中间表对象
	 */
	private static final long serialVersionUID = 6587968124359778878L;
	private Integer id;
	private String username;
	private String password;
	private Integer state;
	private String realname;
	private String idcard;
	private String phone;
	private Integer isemp;
	private Integer uid;
	private Integer rid;
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
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
}
