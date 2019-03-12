package com.rg1803.pojo;

import java.io.Serializable;

public class UserVo implements Serializable{

	/**
	 * 模糊查询和分组需要的对象
	 */
	private static final long serialVersionUID = 6026777443728593002L;
	private String name;
	private String idcard;
	private String sel;
	private User user;
	private Integer pageNumber;
	private Integer pageSize;
	
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getSel() {
		return sel;
	}
	public void setSel(String sel) {
		this.sel = sel;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
