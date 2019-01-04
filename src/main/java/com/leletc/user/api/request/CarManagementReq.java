package com.leletc.user.api.request;

import java.util.Date;

public class CarManagementReq {
	// 用户ID
	private String UserId;

	private String CarNum;

	private String Model;

	private Date Age;

	private String DESC;

	/**
	 * @param userId
	 * @param carNum
	 * @param model
	 * @param age
	 * @param dESC
	 */
	public CarManagementReq(String userId, String carNum, String model, Date age, String dESC) {
		super();
		UserId = userId;
		CarNum = carNum;
		Model = model;
		Age = age;
		DESC = dESC;
	}

	/**
	 * 
	 */
	public CarManagementReq() {
		super();
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return UserId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		UserId = userId;
	}

	/**
	 * @return the carNum
	 */
	public String getCarNum() {
		return CarNum;
	}

	/**
	 * @param carNum the carNum to set
	 */
	public void setCarNum(String carNum) {
		CarNum = carNum;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return Model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		Model = model;
	}

	/**
	 * @return the age
	 */
	public Date getAge() {
		return Age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Date age) {
		Age = age;
	}

	/**
	 * @return the dESC
	 */
	public String getDESC() {
		return DESC;
	}

	/**
	 * @param dESC the dESC to set
	 */
	public void setDESC(String dESC) {
		DESC = dESC;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CarManagementReq [UserId=" + UserId + ", CarNum=" + CarNum + ", Model=" + Model + ", Age=" + Age
				+ ", DESC=" + DESC + "]";
	}

}
