package com.jeecg.wechat.page;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository
public class KeyWordPage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fNum;
	private String fShow;
	private String fName;

	public String getfNum() {
		return fNum;
	}

	public void setfNum(String fNum) {
		this.fNum = fNum;
	}

	public String getfShow() {
		return fShow;
	}

	public void setfShow(String fShow) {
		this.fShow = fShow;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	@Override
	public String toString() {
		return "KeyWordDto [fNum=" + fNum + ", fShow=" + fShow + ", fName=" + fName + "]";
	}

}
