package com.jeecg.wechat.entity;

public class OpenIdTokenModel {

	// 用户id
	private String openid;

	// 随机生成的uuid
	private String token;

	/**
	 * 
	 */
	public OpenIdTokenModel() {
		super();
	}

	/**
	 * @param openid
	 * @param token
	 */
	public OpenIdTokenModel(String openid, String token) {
		super();
		this.openid = openid;
		this.token = token;
	}

	/**
	 * @return the openid
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * @param openid the openid to set
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OpenIdTokenModel [openid=" + openid + ", token=" + token + "]";
	}

}
