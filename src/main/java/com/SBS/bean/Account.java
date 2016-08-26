package com.SBS.bean;

import java.io.Serializable;

public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String pwd;
	private String role;
	
	public String getName() {
		return name;
	}
	public Account setName(String name) {
		this.name = name;
		return this;
	}
	public String getPwd() {
		return pwd;
	}
	public Account setPwd(String pwd) {
		this.pwd = pwd;
		return this;
	}
	public String getRole() {
		return role;
	}
	public Account setRole(String role) {
		this.role = role;
		return this;
	}

}
