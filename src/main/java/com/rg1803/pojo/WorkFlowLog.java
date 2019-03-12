package com.rg1803.pojo;

import java.io.Serializable;
import java.util.Date;

public class WorkFlowLog implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8295184494189814041L;
	private Integer id;
	private Date workdate;
	private String option;
	private Integer wid;
	private String spman;
	private String sprole;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getWorkdate() {
		return workdate;
	}
	public void setWorkdate(Date workdate) {
		this.workdate = workdate;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public Integer getWid() {
		return wid;
	}
	public void setWid(Integer wid) {
		this.wid = wid;
	}
	public String getSpman() {
		return spman;
	}
	public void setSpman(String spman) {
		this.spman = spman;
	}
	public String getSprole() {
		return sprole;
	}
	public void setSprole(String sprole) {
		this.sprole = sprole;
	}
	
}
