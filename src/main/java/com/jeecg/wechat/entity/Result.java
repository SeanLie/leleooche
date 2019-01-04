package com.jeecg.wechat.entity;

public class Result {
	private int code;
	private String desc;
	private Object data;
	
	
	
	public Result() {
		super();
	}
	public Result(int code, String desc, Object data) {
		super();
		this.code = code;
		this.desc = desc;
		this.data = data;
	}
	
	public static Result success(int code, String desc, Object data) {
		return new Result(code, desc, data);
	}
	public static Result success( String desc, Object data) {
		return new Result(1, desc, data);
	}
	
	public static Result failure(int code, String desc, Object data) {
		return new Result(code, desc, data);
	}
	public static Result failure( String desc, Object data) {
		return new Result(-1, desc, data);
	}
	
	public int getCode() {
		return code;
	}
	public Result setCode(int code) {
		this.code = code;
		return this;
	}
	public String getDesc() {
		return desc;
	}
	public Result setDesc(String desc) {
		this.desc = desc;
		return this;
	}
	public Object getData() {
		return data;
	}
	public Result setData(Object data) {
		this.data = data;
		return this;
	}
	@Override
	public String toString() {
		return "Result [code=" + code + ", desc=" + desc + ", data=" + data + "]";
	}
	

}
