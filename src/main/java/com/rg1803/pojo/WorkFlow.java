package com.rg1803.pojo;

import java.io.Serializable;

public class WorkFlow implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8954450954920581960L;
	private Integer id;
	private Integer lid;
	private Integer state;
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
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
}
