package com.rg1803.pojo;

import java.io.Serializable;

public class Role implements Serializable{

	/**
	 * 员工角色对象
	 */
	private static final long serialVersionUID = 3426657168178818123L;
	private Integer id;
	private String role;
	private Integer level;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
}
