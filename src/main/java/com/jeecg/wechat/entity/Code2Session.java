package com.jeecg.wechat.entity;

public class Code2Session {
	// 用户唯一标识
	private String openid;
	// 会话密钥
	private String session_key;
	// 用户在开放平台的唯一标识符，在满足 UnionID 下发条件的情况下会返回，详见 UnionID 机制说明。
	private String unionid;
	// 错误码
	private Number errcode;
	// 错误信息
	private String errMsg;

	/**
	 * 
	 */
	public Code2Session() {
		super();
	}

	/**
	 * @param openid
	 * @param session_key
	 * @param unionid
	 * @param errcode
	 * @param errMsg
	 */
	public Code2Session(String openid, String session_key, String unionid, Number errcode, String errMsg) {
		super();
		this.openid = openid;
		this.session_key = session_key;
		this.unionid = unionid;
		this.errcode = errcode;
		this.errMsg = errMsg;
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
	 * @return the session_key
	 */
	public String getSession_key() {
		return session_key;
	}

	/**
	 * @param session_key the session_key to set
	 */
	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}

	/**
	 * @return the unionid
	 */
	public String getUnionid() {
		return unionid;
	}

	/**
	 * @param unionid the unionid to set
	 */
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	/**
	 * @return the errcode
	 */
	public Number getErrcode() {
		return errcode;
	}

	/**
	 * @param errcode the errcode to set
	 */
	public void setErrcode(Number errcode) {
		this.errcode = errcode;
	}

	/**
	 * @return the errMsg
	 */
	public String getErrMsg() {
		return errMsg;
	}

	/**
	 * @param errMsg the errMsg to set
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Code2Session [openid=" + openid + ", session_key=" + session_key + ", unionid=" + unionid + ", errcode="
				+ errcode + ", errMsg=" + errMsg + "]";
	}

}
