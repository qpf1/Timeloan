package com.rg1803.pojo;

import java.io.Serializable;

public class WorkFlowNode implements Serializable{

	/**
	 * 贷款流对象
	 */
	private static final long serialVersionUID = 466556291923703936L;
	private Integer id;
	private String node;
	private Integer wid;
	private String nownode;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
	public Integer getWid() {
		return wid;
	}
	public void setWid(Integer wid) {
		this.wid = wid;
	}
	public String getNownode() {
		return nownode;
	}
	public void setNownode(String nownode) {
		this.nownode = nownode;
	}
}
