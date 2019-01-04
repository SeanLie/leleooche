package com.jeecg.wechat.page;

public class MsgDataPage {
	private String name;
	private String color;

	public MsgDataPage(String name, String color) {
		this.color = color;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
