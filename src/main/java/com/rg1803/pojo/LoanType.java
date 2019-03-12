package com.rg1803.pojo;

import java.io.Serializable;

public class LoanType implements Serializable{

	/**
	 * 贷款类型对象
	 */
	private static final long serialVersionUID = -2829867786975164852L;
	private Integer id;
	private String type;
	private String node;
	private Integer wid;
	private String nownode;
	
	public String getNownode() {
		return nownode;
	}
	public void setNownode(String nownode) {
		this.nownode = nownode;
	}
	public Integer getWid() {
		return wid;
	}
	public void setWid(Integer wid) {
		this.wid = wid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
}
