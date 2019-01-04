package com.leletc.oocheorder.web.api.request;

import com.leletc.base.api.response.RspHead;

import java.util.Date;

/*
 * 剩余次数接口
 */
public class ReserveRsp extends RspHead {

	/** 当前系统时间 */
	private Date systenDate;

	/** 预约时间范围 */
	private String systemDateDsc;

	/** 当前预约队列数 */
	private int orderNum;

	/** 预约剩余次数 */
	private String leftnum;

	/**
	 * 
	 */
	public ReserveRsp() {
		super();
	}

	/**
	 * @param systenDate
	 * @param systemDateDsc
	 * @param orderNum
	 * @param leftnum
	 */
	public ReserveRsp(Date systenDate, String systemDateDsc, int orderNum, String leftnum) {
		super();
		this.systenDate = systenDate;
		this.systemDateDsc = systemDateDsc;
		this.orderNum = orderNum;
		this.leftnum = leftnum;
	}

	/**
	 * @return the systenDate
	 */
	public Date getSystenDate() {
		return systenDate;
	}

	/**
	 * @param systenDate the systenDate to set
	 */
	public void setSystenDate(Date systenDate) {
		this.systenDate = systenDate;
	}

	/**
	 * @return the systemDateDsc
	 */
	public String getSystemDateDsc() {
		return systemDateDsc;
	}

	/**
	 * @param systemDateDsc the systemDateDsc to set
	 */
	public void setSystemDateDsc(String systemDateDsc) {
		this.systemDateDsc = systemDateDsc;
	}

	/**
	 * @return the orderNum
	 */
	public int getOrderNum() {
		return orderNum;
	}

	/**
	 * @param orderNum the orderNum to set
	 */
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	/**
	 * @return the leftnum
	 */
	public String getLeftnum() {
		return leftnum;
	}

	/**
	 * @param leftnum the leftnum to set
	 */
	public void setLeftnum(String leftnum) {
		this.leftnum = leftnum;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReserveRsp [systenDate=" + systenDate + ", systemDateDsc=" + systemDateDsc + ", orderNum=" + orderNum
				+ ", leftnum=" + leftnum + "]";
	}

}
