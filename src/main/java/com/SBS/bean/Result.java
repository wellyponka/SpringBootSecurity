package com.SBS.bean;

import java.util.List;

public class Result<E> {
	
	private int error;
	private String msg;
	private List<E> data;
	
	public int getError() {
		return error;
	}
	public Result<E> setError(int error) {
		this.error = error;
		return this;
	}
	public String getMsg() {
		return msg;
	}
	public Result<E> setMsg(String msg) {
		this.msg = msg;
		return this;
	}
	public List<E> getData() {
		return data;
	}
	public Result<E> setData(List<E> data) {
		this.data = data;
		return this;
	}
}
